package config;

import org.flywaydb.core.Flyway;

public class FlyWayConfiguracao {
    public static void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource(
                        "jdbc:postgresql://localhost:5432/dbautocentersilva",
                        "postgres",
                        "2020"
                )
                .locations("classpath:db.migration")
                .baselineOnMigrate(true)
                .load();
        flyway.migrate();
    }
}