# 💳 Sistema de Gestión de Pagos

## 📝 Descripción:

Este proyecto en Java implementa un sistema flexible para la gestión de diferentes métodos de pago. Utiliza una interfaz común para permitir el procesamiento de pagos a través de múltiples canales.

### ✨ Características principales:

1.  **💳 Variedad de Métodos:** Soporte para Tarjeta de Crédito, PayPal, Transferencia Bancaria, Bitcoin y Tarjeta de Regalo.
2.  **✅ Validación de Montos:** Cada método de pago tiene sus propias reglas de validación (por ejemplo, montos mínimos para Bitcoin).
3.  **📝 Detalles Formateados:** Generación de resúmenes detallados de cada transacción.
4.  **🔄 Abstracción:** Uso de la interfaz `MetodoPago` para desacoplar el procesamiento del pago de la implementación específica.

## 🧱 Estructura del Proyecto:

- `MetodoPago`: Interfaz que define las operaciones básicas (procesar, detallar, validar).
- Implementaciones: `TarjetaCredito`, `Paypal`, `TransferenciaBancaria`, `Bitcoin`, `TarjetaRegalo`.
- `Main`: Clase principal que maneja la selección del método de pago y el flujo de la transacción.

## 🛠️ Tecnologías Utilizadas:

- **Java** ☕: Lenguaje de programación.

---

# 💳 Payment Management System

## 📝 Description:

This Java project implements a flexible system for managing different payment methods. It uses a common interface to allow payment processing through multiple channels.

### ✨ Key Features:

1.  **💳 Variety of Methods:** Support for Credit Card, PayPal, Bank Transfer, Bitcoin, and Gift Card.
2.  **✅ Amount Validation:** Each payment method has its own validation rules (e.g., minimum amounts for Bitcoin).
3.  **📝 Formatted Details:** Generation of detailed summaries for each transaction.
4.  **🔄 Abstraction:** Use of the `MetodoPago` interface to decouple payment processing from the specific implementation.

## 🧱 Project Structure:

- `MetodoPago`: Interface defining basic operations (process, detail, validate).
- Implementations: `TarjetaCredito`, `Paypal`, `TransferenciaBancaria`, `Bitcoin`, `TarjetaRegalo`.
- `Main`: Main class handling payment method selection and transaction flow.

## 🛠️ Technologies Used:

- **Java** ☕: Programming language.
