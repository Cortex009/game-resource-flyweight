# Game Resource Management Engine

A Java-based simulation demonstrating the **Flyweight Design Pattern** to optimize memory allocation in high-load backend environments. This project models a game engine rendering 100,000 projectile objects efficiently by separating intrinsic and extrinsic states.

## 🚀 The Problem & Solution

**Problem:** Storing heavy assets (like a 1KB image byte array, damage stats, and physics profiles) inside 100,000 independent bullet objects consumes excessive heap memory (approx. 100MB+), leading to lag and garbage collection pauses.

**Solution:** The Flyweight pattern extracts the shared, immutable data into a cached `BulletType` class. The 100,000 `Bullet` instances only store their unique extrinsic state (coordinates and trajectory) and reference the shared flyweight objects.

## 🏗️ Architecture

*   **Intrinsic State (`BulletType.java`):** Encapsulates shared, immutable properties (color, weight, max damage, image payload).
*   **Extrinsic State (`Bullet.java`):** Maintains the unique, mutable context (X/Y/Z coordinates, speed) and a reference to the `BulletType`.
*   **Flyweight Factory (`BulletTypeFactory.java`):** Utilizes a `HashMap` cache to intercept instantiation requests, returning existing `BulletType` objects rather than creating duplicates.
*   **Simulation (`Client.java`):** Generates 100,000 projectiles using only 4 unique `BulletType` objects in memory.

## 🛠️ Tech Stack
*   **Language:** Java 24
*   **Build Tool:** Maven
*   **Core Concepts:** Object-Oriented Programming (OOP), Design Patterns, Caching, Memory Optimization

## ⚙️ How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/cortex009/game-resource-flyweight.git
   