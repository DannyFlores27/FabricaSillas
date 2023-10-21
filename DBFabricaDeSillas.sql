SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema FabricaDeSillas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema FabricaDeSillas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FabricaDeSillas` DEFAULT CHARACTER SET utf8 ;
USE `FabricaDeSillas` ;

-- -----------------------------------------------------
-- Table `FabricaDeSillas`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FabricaDeSillas`.`cliente` (
  `nit` VARCHAR(8) NOT NULL,
  `id` INT NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `apellido` VARCHAR(20) NOT NULL,
  `residencia` VARCHAR(80) NOT NULL,
  `telefono` VARCHAR(8) NOT NULL,
  `categoria_cliente` ENUM('SILVER', 'GOLD', 'PLATINUM') NOT NULL,
  UNIQUE INDEX `nit_UNIQUE` (`nit` ASC) VISIBLE,
  UNIQUE INDEX `telefono_UNIQUE` (`telefono` ASC) VISIBLE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FabricaDeSillas`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FabricaDeSillas`.`factura` (
  `id` INT NOT NULL,
  `estado_factura` ENUM('SIN_PAGAR', 'ANTICIPO_CANCELADO', 'TOTAL_CANCELADO') NOT NULL,
  `total_a_pagar_sin_iva` DOUBLE NOT NULL,
  `total_a_pagar` DOUBLE NOT NULL,
  `saldo` DOUBLE NOT NULL,
  `iva` DOUBLE NOT NULL,
  `anticipo` DOUBLE NOT NULL,
  `anticipo_pagado` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FabricaDeSillas`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FabricaDeSillas`.`pedido` (
  `id` INT NOT NULL,
  `total_precio_productos` DOUBLE NOT NULL,
  `tiempo` DOUBLE NOT NULL,
  `etapa` ENUM('EN_COLA', 'EN_PRODUCCION') NOT NULL,
  `entrega` ENUM('DELIVERY', 'EN_TIENDA') NOT NULL,
  `factura_id_factura` INT NOT NULL,
  `factura_id_factura1` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pedido_factura1_idx` (`factura_id_factura1` ASC) VISIBLE,
  CONSTRAINT `pedido_cliente`
    FOREIGN KEY (`id`)
    REFERENCES `FabricaDeSillas`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_factura1`
    FOREIGN KEY (`factura_id_factura1`)
    REFERENCES `FabricaDeSillas`.`factura` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FabricaDeSillas`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FabricaDeSillas`.`producto` (
  `id` INT NOT NULL,
  `tiempo` INT NOT NULL,
  `precio` DOUBLE NOT NULL,
  `etapa` ENUM('EN_COLA', 'EN_PRODUCCION') NOT NULL,
  `color_producto` ENUM('NATURAL_CLARO', 'NATURAL_OSCURO', 'BLANCO', 'BLANCO_ROTO', 'NEGRO', 'NEGRO_OXIDO', 'ROJO', 'PERSONALIZADO') NOT NULL,
  `modelo_producto` ENUM('VINTAGE_RETRO', 'COLONIAL', 'RUSTICO', 'CLASICO', 'MODERNO_CONTEMPORANEO', 'NORDICO_ESCANDINAVO_A1', 'NORDICO_ESCANDINAVO_A2', 'DESCANSO', 'DESCANSO_CON_BRAZOS', 'INFANTIL_OVAL', 'INFANTIL_REDONDA', 'EXTERIOR', 'EXTERIOR_CON_BRAZOS', 'JUVENIL_A1', 'JUVENIL_A2', 'INDUSTRIAL_A1', 'INDUSTRIAL_A2') NOT NULL,
  `tipo_producto` ENUM('COMEDOR_CLASICO', 'COMEDOR_ALTO', 'ISLA_COCINA', 'BARRA', 'BANCO_CLASICO', 'BANCO_ALTO') NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `producto_pedido`
    FOREIGN KEY (`id`)
    REFERENCES `FabricaDeSillas`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
