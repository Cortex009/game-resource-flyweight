package com.github.cortex009.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
        private static final int BULLETS_TO_RENDER = 100000;
        private static final String[] WEAPON_TYPES = {"AKM", "M416", "UMP45", "AWM"};

        public static void main(String[] args) {
            System.out.println("Initializing Game Engine Simulation...");
            List<Bullet> activeBullets = new ArrayList<>();
            Random random = new Random();

            Runtime runtime = Runtime.getRuntime();
            runtime.gc();
            long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
            long startTime = System.currentTimeMillis();

            // Simulate firing 100,000 bullets
            for (int i = 0; i < BULLETS_TO_RENDER; i++) {
                String randomWeapon = WEAPON_TYPES[random.nextInt(WEAPON_TYPES.length)];

                // Retrieve shared intrinsic state (Flyweight)
                BulletType type = BulletTypeFactory.getBulletType(randomWeapon);

                // Instantiate unique extrinsic state
                Bullet bullet = new Bullet(
                        type,
                        random.nextDouble(), random.nextDouble(), random.nextDouble(),
                        800.0,
                        random.nextDouble() * 100, random.nextDouble() * 100, random.nextDouble() * 100,
                        random.nextDouble() * 1000, random.nextDouble() * 1000, random.nextDouble() * 1000
                );

                activeBullets.add(bullet);
            }

            long endTime = System.currentTimeMillis();
            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

            System.out.println("\n--- Simulation Results ---");
            System.out.println("Active Bullet Instances: " + activeBullets.size());
            System.out.println("Unique BulletType Objects in Memory: " + BulletTypeFactory.CACHE.size());
            System.out.println("Execution Time: " + (endTime - startTime) + " ms");
            System.out.println("Approximate Memory Used: " + ((memoryAfter - memoryBefore) / (1024 * 1024)) + " MB");
            System.out.println("Memory overhead was minimized by reusing the heavy byte[] image payloads in the Cache.");
        }

}