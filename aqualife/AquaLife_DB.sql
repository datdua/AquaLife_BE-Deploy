-- Database: PRM392_AquaLife

-- DROP DATABASE IF EXISTS "PRM392_AquaLife";

-- CREATE DATABASE "PRM392_AquaLife"
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     LC_COLLATE = 'vi-VN'
--     LC_CTYPE = 'vi-VN'
--     LOCALE_PROVIDER = 'libc'
--     TABLESPACE = pg_default
--     CONNECTION LIMIT = -1
--     IS_TEMPLATE = False;

USING DATABASE "PRM392_AquaLife"

CREATE TYPE "role_type" AS ENUM (
  'Customer',
  'Admin',
  'Manager',
  'Staff'
);

CREATE TYPE "product_type" AS ENUM (
  'Fish',
  'Food',
  'Medicine',
  'Aquarium'
);

CREATE TYPE "product_status" AS ENUM (
  'in stock',
  'out of stock'
);

CREATE TYPE "food_type" AS ENUM (
  'dry',
  'fresh'
);

CREATE TYPE "shipping_status" AS ENUM (
  'pending',
  'shipping',
  'done'
);

CREATE TYPE "order_status" AS ENUM (
  'done',
  'cancel',
  'pending'
);

CREATE TABLE "User" (
  "UserID" SERIAL PRIMARY KEY NOT NULL,
  "FullName" VARCHAR(50) UNIQUE NOT NULL,
  "PasswordHash" VARCHAR(255) NOT NULL,
  "Email" VARCHAR(100) UNIQUE,
  "PhoneNumber" VARCHAR(20) UNIQUE,
  "Address" TEXT,
  "Role" role_type NOT NULL,
  "AvatarUrl" TEXT
);

CREATE TABLE "Product" (
  "ProductID" SERIAL PRIMARY KEY NOT NULL,
  "ProductType" product_type NOT NULL,
  "ProductName" VARCHAR(100) NOT NULL,
  "ProductStatus" product_status NOT NULL,
  "ImageUrl" TEXT,
  "Description" TEXT,
  "Quantity" INTEGER NOT NULL,
  "Price" DECIMAL(10,2) NOT NULL
);

CREATE TABLE "Fish" (
  "ProductID" INTEGER PRIMARY KEY NOT NULL,
  "FishType" VARCHAR(50) NOT NULL,
  "FishFood" TEXT NOT NULL,
  "Color" VARCHAR(50) NOT NULL,
  "Behavior" TEXT NOT NULL,
  "Temperature" VARCHAR(50) NOT NULL,
  "pH" VARCHAR(50) NOT NULL
);

CREATE TABLE "Food" (
  "ProductID" INTEGER PRIMARY KEY NOT NULL,
  "FoodType" food_type NOT NULL,
  "pH" VARCHAR(50) NOT NULL
);

CREATE TABLE "Medicine" (
  "ProductID" INTEGER PRIMARY KEY NOT NULL,
  "MedicineType" VARCHAR(50) NOT NULL
);

CREATE TABLE "Aquarium" (
  "ProductID" INTEGER PRIMARY KEY NOT NULL,
  "Size" VARCHAR(50) NOT NULL
);

CREATE TABLE "Cart" (
  "CartID" SERIAL PRIMARY KEY NOT NULL,
  "UserID" INTEGER NOT NULL,
  "TotalPrice" DECIMAL(10,2) NOT NULL,
  "CartStatus" VARCHAR(50) NOT NULL
);

CREATE TABLE "CartItem" (
  "CartItemID" SERIAL PRIMARY KEY NOT NULL,
  "CartID" INTEGER NOT NULL,
  "ProductID" INTEGER NOT NULL,
  "Quantity" INTEGER NOT NULL,
  "Price" DECIMAL(10,2) NOT NULL
);

CREATE TABLE "UserAdd" (
  "UserAddID" SERIAL PRIMARY KEY NOT NULL,
  "UserID" INTEGER NOT NULL,
  "ShippingAddress" TEXT NOT NULL,
  "isDefault" BOOLEAN NOT NULL DEFAULT '0',
  "ShippingPhone" VARCHAR(20) NOT NULL
);

CREATE TABLE "Shipping" (
  "ShippingID" SERIAL PRIMARY KEY NOT NULL,
  "UserAddID" INTEGER NOT NULL,
  "Description" TEXT,
  "ShippingStatus" shipping_status NOT NULL,
  "DeliveryDate" TIMESTAMP
);

CREATE TABLE "Order" (
  "OrderID" SERIAL PRIMARY KEY NOT NULL,
  "CartID" INTEGER NOT NULL,
  "UserID" INTEGER NOT NULL,
  "ShippingID" BIGINT NOT NULL,
  "PaymentMethod" VARCHAR(50) NOT NULL,
  "OrderStatus" order_status NOT NULL,
  "OrderDate" TIMESTAMP(0) NOT NULL
);

CREATE TABLE "Payment" (
  "PaymentID" SERIAL PRIMARY KEY NOT NULL,
  "OrderID" INTEGER NOT NULL,
  "Amount" DECIMAL(10,2) NOT NULL,
  "PaymentDate" TIMESTAMP(0) NOT NULL,
  "PaymentStatus" VARCHAR(50) NOT NULL
);

CREATE TABLE "Notification" (
  "NotificationID" SERIAL PRIMARY KEY NOT NULL,
  "UserID" INTEGER NOT NULL,
  "Message" TEXT,
  "isRead" BOOLEAN NOT NULL DEFAULT false,
  "CreateAt" TIMESTAMP(0) NOT NULL
);

CREATE TABLE "ChatMessage" (
  "ChatMessageID" SERIAL PRIMARY KEY NOT NULL,
  "UserID" INTEGER NOT NULL,
  "Message" TEXT NOT NULL,
  "SendAt" TIMESTAMP(0) NOT NULL
);

CREATE TABLE "Comment" (
  "CommentID" SERIAL PRIMARY KEY NOT NULL,
  "UserID" INTEGER NOT NULL,
  "Text" TEXT NOT NULL,
  "CreateAt" TIMESTAMP(0) NOT NULL
);

CREATE TABLE "Blog" (
  "BlogID" SERIAL PRIMARY KEY NOT NULL,
  "CommentID" INTEGER NOT NULL,
  "BlogTitle" VARCHAR(200) NOT NULL,
  "Description" TEXT NOT NULL
);

COMMENT ON COLUMN "Product"."Quantity" IS 'CHECK (Quantity >= 0)';

COMMENT ON COLUMN "Product"."Price" IS 'CHECK (Price >= 0)';

COMMENT ON COLUMN "Cart"."TotalPrice" IS 'CHECK (TotalPrice >= 0)';

COMMENT ON COLUMN "CartItem"."Quantity" IS 'CHECK (Quantity > 0)';

COMMENT ON COLUMN "CartItem"."Price" IS 'CHECK (Price >= 0)';

COMMENT ON COLUMN "Payment"."Amount" IS 'CHECK (Amount >= 0)';

ALTER TABLE "Fish" ADD FOREIGN KEY ("ProductID") REFERENCES "Product" ("ProductID");

ALTER TABLE "Food" ADD FOREIGN KEY ("ProductID") REFERENCES "Product" ("ProductID");

ALTER TABLE "Medicine" ADD FOREIGN KEY ("ProductID") REFERENCES "Product" ("ProductID");

ALTER TABLE "Aquarium" ADD FOREIGN KEY ("ProductID") REFERENCES "Product" ("ProductID");

ALTER TABLE "Cart" ADD FOREIGN KEY ("UserID") REFERENCES "User" ("UserID");

ALTER TABLE "CartItem" ADD FOREIGN KEY ("CartID") REFERENCES "Cart" ("CartID");

ALTER TABLE "CartItem" ADD FOREIGN KEY ("ProductID") REFERENCES "Product" ("ProductID");

ALTER TABLE "UserAdd" ADD FOREIGN KEY ("UserID") REFERENCES "User" ("UserID");

ALTER TABLE "Shipping" ADD FOREIGN KEY ("UserAddID") REFERENCES "UserAdd" ("UserAddID");

ALTER TABLE "Order" ADD FOREIGN KEY ("CartID") REFERENCES "Cart" ("CartID");

ALTER TABLE "Order" ADD FOREIGN KEY ("UserID") REFERENCES "User" ("UserID");

ALTER TABLE "Order" ADD FOREIGN KEY ("ShippingID") REFERENCES "Shipping" ("ShippingID");

ALTER TABLE "Payment" ADD FOREIGN KEY ("OrderID") REFERENCES "Order" ("OrderID");

ALTER TABLE "Notification" ADD FOREIGN KEY ("UserID") REFERENCES "User" ("UserID");

ALTER TABLE "ChatMessage" ADD FOREIGN KEY ("UserID") REFERENCES "User" ("UserID");

ALTER TABLE "Comment" ADD FOREIGN KEY ("UserID") REFERENCES "User" ("UserID");

ALTER TABLE "Blog" ADD FOREIGN KEY ("CommentID") REFERENCES "Comment" ("CommentID");
