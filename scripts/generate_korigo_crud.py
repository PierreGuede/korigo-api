from pathlib import Path
import textwrap


ROOT = Path(__file__).resolve().parents[1]
SRC_MAIN = ROOT / "src" / "main" / "java"
SRC_TEST = ROOT / "src" / "test" / "java"
BASE_PACKAGE = "com.korigo.api"
BASE_DIR = SRC_MAIN / "com" / "korigo" / "api"


def camel_to_snake(value: str) -> str:
    chars = []
    for index, char in enumerate(value):
        if char.isupper() and index > 0:
            chars.append("_")
        chars.append(char.lower())
    return "".join(chars)


def lower_first(value: str) -> str:
    return value[:1].lower() + value[1:]


ENTITIES = [
    {
        "package": "role",
        "class": "Role",
        "path": "roles",
        "fields": [
            {"name": "nom", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "description", "type": "String", "required": False, "annotation": None},
        ],
        "relations": [],
    },
    {
        "package": "utilisateur",
        "class": "Utilisateur",
        "path": "utilisateurs",
        "fields": [
            {"name": "nom", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "telephone", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "email", "type": "String", "required": True, "annotation": "@Email"},
        ],
        "relations": [
            {
                "name": "role",
                "target_package": "role",
                "target_class": "Role",
                "kind": "many_to_one",
                "required": True,
            }
        ],
    },
    {
        "package": "chauffeur",
        "class": "Chauffeur",
        "path": "chauffeurs",
        "fields": [
            {"name": "actif", "type": "Boolean", "required": True, "annotation": "@NotNull"},
            {"name": "statut", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "note", "type": "Double", "required": False, "annotation": "@PositiveOrZero"},
        ],
        "relations": [
            {
                "name": "utilisateur",
                "target_package": "utilisateur",
                "target_class": "Utilisateur",
                "kind": "one_to_one",
                "required": True,
            }
        ],
    },
    {
        "package": "vehicule",
        "class": "Vehicule",
        "path": "vehicules",
        "fields": [
            {"name": "type", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "marque", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "modele", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "immatriculation", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "couleur", "type": "String", "required": False, "annotation": None},
        ],
        "relations": [
            {
                "name": "chauffeur",
                "target_package": "chauffeur",
                "target_class": "Chauffeur",
                "kind": "many_to_one",
                "required": True,
            }
        ],
    },
    {
        "package": "course",
        "class": "Course",
        "path": "courses",
        "fields": [
            {"name": "distanceKm", "type": "Double", "required": True, "annotation": "@PositiveOrZero"},
            {"name": "prix", "type": "Double", "required": True, "annotation": "@PositiveOrZero"},
            {"name": "statut", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "startTime", "type": "LocalDateTime", "required": True, "annotation": "@NotNull"},
            {"name": "endTime", "type": "LocalDateTime", "required": False, "annotation": None},
        ],
        "relations": [
            {
                "name": "client",
                "target_package": "utilisateur",
                "target_class": "Utilisateur",
                "kind": "many_to_one",
                "required": True,
            },
            {
                "name": "chauffeur",
                "target_package": "chauffeur",
                "target_class": "Chauffeur",
                "kind": "many_to_one",
                "required": True,
            },
            {
                "name": "vehicule",
                "target_package": "vehicule",
                "target_class": "Vehicule",
                "kind": "many_to_one",
                "required": True,
            },
        ],
    },
    {
        "package": "trajetgps",
        "class": "TrajetGps",
        "path": "trajets-gps",
        "fields": [
            {"name": "latitude", "type": "Double", "required": True, "annotation": "@NotNull"},
            {"name": "longitude", "type": "Double", "required": True, "annotation": "@NotNull"},
            {"name": "timestamp", "type": "LocalDateTime", "required": True, "annotation": "@NotNull"},
        ],
        "relations": [
            {
                "name": "course",
                "target_package": "course",
                "target_class": "Course",
                "kind": "many_to_one",
                "required": True,
            }
        ],
    },
    {
        "package": "restaurant",
        "class": "Restaurant",
        "path": "restaurants",
        "fields": [
            {"name": "nom", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "adresse", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "telephone", "type": "String", "required": True, "annotation": "@NotBlank"},
        ],
        "relations": [],
    },
    {
        "package": "commande",
        "class": "Commande",
        "path": "commandes",
        "fields": [
            {"name": "montant", "type": "Double", "required": True, "annotation": "@PositiveOrZero"},
            {"name": "statut", "type": "String", "required": True, "annotation": "@NotBlank"},
        ],
        "relations": [
            {
                "name": "client",
                "target_package": "utilisateur",
                "target_class": "Utilisateur",
                "kind": "many_to_one",
                "required": True,
            },
            {
                "name": "restaurant",
                "target_package": "restaurant",
                "target_class": "Restaurant",
                "kind": "many_to_one",
                "required": True,
            },
            {
                "name": "chauffeur",
                "target_package": "chauffeur",
                "target_class": "Chauffeur",
                "kind": "many_to_one",
                "required": True,
            },
        ],
    },
    {
        "package": "colis",
        "class": "Colis",
        "path": "colis",
        "fields": [
            {"name": "description", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "poids", "type": "Double", "required": True, "annotation": "@PositiveOrZero"},
        ],
        "relations": [
            {
                "name": "commande",
                "target_package": "commande",
                "target_class": "Commande",
                "kind": "many_to_one",
                "required": True,
            }
        ],
    },
    {
        "package": "paiement",
        "class": "Paiement",
        "path": "paiements",
        "fields": [
            {"name": "mode", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "montant", "type": "Double", "required": True, "annotation": "@PositiveOrZero"},
        ],
        "relations": [
            {
                "name": "utilisateur",
                "target_package": "utilisateur",
                "target_class": "Utilisateur",
                "kind": "many_to_one",
                "required": True,
            },
            {
                "name": "course",
                "target_package": "course",
                "target_class": "Course",
                "kind": "many_to_one",
                "required": False,
            },
            {
                "name": "commande",
                "target_package": "commande",
                "target_class": "Commande",
                "kind": "many_to_one",
                "required": False,
            },
        ],
    },
    {
        "package": "wallettransaction",
        "class": "WalletTransaction",
        "path": "wallet-transactions",
        "fields": [
            {"name": "type", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "montant", "type": "Double", "required": True, "annotation": "@PositiveOrZero"},
            {"name": "description", "type": "String", "required": False, "annotation": None},
        ],
        "relations": [
            {
                "name": "utilisateur",
                "target_package": "utilisateur",
                "target_class": "Utilisateur",
                "kind": "many_to_one",
                "required": True,
            }
        ],
    },
    {
        "package": "commission",
        "class": "Commission",
        "path": "commissions",
        "fields": [
            {"name": "montant", "type": "Double", "required": True, "annotation": "@PositiveOrZero"},
            {"name": "pourcentage", "type": "Double", "required": True, "annotation": "@PositiveOrZero"},
        ],
        "relations": [
            {
                "name": "course",
                "target_package": "course",
                "target_class": "Course",
                "kind": "one_to_one",
                "required": True,
            }
        ],
    },
    {
        "package": "retrait",
        "class": "Retrait",
        "path": "retraits",
        "fields": [
            {"name": "montant", "type": "Double", "required": True, "annotation": "@PositiveOrZero"},
            {"name": "methode", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "statut", "type": "String", "required": True, "annotation": "@NotBlank"},
        ],
        "relations": [
            {
                "name": "chauffeur",
                "target_package": "chauffeur",
                "target_class": "Chauffeur",
                "kind": "many_to_one",
                "required": True,
            }
        ],
    },
    {
        "package": "kycdocument",
        "class": "KycDocument",
        "path": "kyc-documents",
        "fields": [
            {"name": "typeDocument", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "statut", "type": "String", "required": True, "annotation": "@NotBlank"},
        ],
        "relations": [
            {
                "name": "chauffeur",
                "target_package": "chauffeur",
                "target_class": "Chauffeur",
                "kind": "many_to_one",
                "required": True,
            }
        ],
    },
    {
        "package": "promotion",
        "class": "Promotion",
        "path": "promotions",
        "fields": [
            {"name": "code", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "reduction", "type": "Double", "required": True, "annotation": "@PositiveOrZero"},
            {"name": "dateDebut", "type": "LocalDateTime", "required": True, "annotation": "@NotNull"},
            {"name": "dateFin", "type": "LocalDateTime", "required": True, "annotation": "@NotNull"},
        ],
        "relations": [],
    },
    {
        "package": "supportticket",
        "class": "SupportTicket",
        "path": "support-tickets",
        "fields": [
            {"name": "sujet", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "message", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "statut", "type": "String", "required": True, "annotation": "@NotBlank"},
        ],
        "relations": [
            {
                "name": "utilisateur",
                "target_package": "utilisateur",
                "target_class": "Utilisateur",
                "kind": "many_to_one",
                "required": True,
            }
        ],
    },
    {
        "package": "zone",
        "class": "Zone",
        "path": "zones",
        "fields": [
            {"name": "nom", "type": "String", "required": True, "annotation": "@NotBlank"},
            {"name": "type", "type": "String", "required": True, "annotation": "@NotBlank"},
        ],
        "relations": [],
    },
]


def write_file(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(textwrap.dedent(content).strip() + "\n", encoding="utf-8")


def validation_imports(entity):
    annotations = {field["annotation"] for field in entity["fields"] if field["annotation"]}
    if any(relation["required"] for relation in entity["relations"]):
        annotations.add("@NotNull")
    if not annotations:
        return ""
    imports = sorted({f"import jakarta.validation.constraints.{annotation[1:]};" for annotation in annotations})
    return "\n".join(imports)


def extra_type_imports(entity):
    imports = set()
    for field in entity["fields"]:
        if field["type"] == "LocalDateTime":
            imports.add("import java.time.LocalDateTime;")
        if field["type"] == "UUID":
            imports.add("import java.util.UUID;")
    if entity["relations"]:
        imports.add("import java.util.UUID;")
    return "\n".join(sorted(imports))


def entity_imports(entity):
    imports = {
        "import com.korigo.api.shared.entities.BaseEntity;",
        "import jakarta.persistence.Column;",
        "import jakarta.persistence.Entity;",
        "import jakarta.persistence.FetchType;",
        "import jakarta.persistence.JoinColumn;",
        "import jakarta.persistence.ManyToOne;",
        "import jakarta.persistence.OneToOne;",
        "import jakarta.persistence.Table;",
        "import lombok.Getter;",
        "import lombok.NoArgsConstructor;",
        "import lombok.Setter;",
    }
    for field in entity["fields"]:
        if field["type"] == "LocalDateTime":
            imports.add("import java.time.LocalDateTime;")
    for relation in entity["relations"]:
        imports.add(
            f"import {BASE_PACKAGE}.{relation['target_package']}.entities.{relation['target_class']};"
        )
    return "\n".join(sorted(imports))


def render_entity(entity):
    columns = []
    for field in entity["fields"]:
        nullable = "false" if field["required"] else "true"
        column_name = camel_to_snake(field["name"])
        columns.append(
            f'    @Column(name = "{column_name}", nullable = {nullable})\n'
            f"    private {field['type']} {field['name']};"
        )
    for relation in entity["relations"]:
        annotation = "@OneToOne" if relation["kind"] == "one_to_one" else "@ManyToOne"
        optional = "false" if relation["required"] else "true"
        nullable = "false" if relation["required"] else "true"
        join_name = f'{camel_to_snake(relation["name"])}_id'
        columns.append(
            f"    {annotation}(fetch = FetchType.LAZY, optional = {optional})\n"
            f'    @JoinColumn(name = "{join_name}", nullable = {nullable})\n'
            f"    private {relation['target_class']} {relation['name']};"
        )
    return f"""
        package {BASE_PACKAGE}.{entity["package"]}.entities;

        {entity_imports(entity)}

        @Getter
        @Setter
        @NoArgsConstructor
        @Entity
        @Table(name = "{camel_to_snake(entity["class"])}")
        public class {entity["class"]} extends BaseEntity {{

        {'\n\n'.join(columns)}
        }}
    """


def render_request(entity):
    imports = []
    validation = validation_imports(entity)
    if validation:
        imports.append(validation)
    type_import = extra_type_imports(entity)
    if type_import:
        imports.append(type_import)

    fields = []
    for field in entity["fields"]:
        if field["annotation"]:
            fields.append(f"    {field['annotation']} {field['type']} {field['name']}")
        else:
            fields.append(f"    {field['type']} {field['name']}")
    for relation in entity["relations"]:
        annotation = "@NotNull " if relation["required"] else ""
        fields.append(
            f"    {annotation}UUID {relation['name']}Id".rstrip()
        )
    imports_block = "\n".join(imports)
    return f"""
        package {BASE_PACKAGE}.{entity["package"]}.dtos;

        {imports_block}

        public record {entity["class"]}Request(
        {',\n'.join(fields)}
        ) {{
        }}
    """


def render_resource(entity):
    imports = extra_type_imports(entity)
    fields = ["    UUID id"]
    fields.extend([f"    {field['type']} {field['name']}" for field in entity["fields"]])
    fields.extend([f"    UUID {relation['name']}Id" for relation in entity["relations"]])
    fields.append("    LocalDateTime createdAt")
    fields.append("    LocalDateTime updatedAt")
    imports_list = ["import java.time.LocalDateTime;", "import java.util.UUID;"]
    return f"""
        package {BASE_PACKAGE}.{entity["package"]}.resources;

        {'\n'.join(sorted(set(imports_list)))}

        public record {entity["class"]}Resource(
        {',\n'.join(fields)}
        ) {{
        }}
    """


def render_mapper(entity):
    imports = {
        f"import {BASE_PACKAGE}.{entity['package']}.dtos.{entity['class']}Request;",
        f"import {BASE_PACKAGE}.{entity['package']}.entities.{entity['class']};",
        f"import {BASE_PACKAGE}.{entity['package']}.resources.{entity['class']}Resource;",
    }
    body_updates = [f"        entity.set{field['name'][0].upper()}{field['name'][1:]}(request.{field['name']}());" for field in entity["fields"]]
    resource_args = ["            entity.getId()"]
    resource_args.extend(
        [f"            entity.get{field['name'][0].upper()}{field['name'][1:]}()" for field in entity["fields"]]
    )
    for relation in entity["relations"]:
        getter = relation["name"][0].upper() + relation["name"][1:]
        resource_args.append(
            f"            entity.get{getter}() != null ? entity.get{getter}().getId() : null"
        )
    resource_args.append("            entity.getCreatedAt()")
    resource_args.append("            entity.getUpdatedAt()")

    return f"""
        package {BASE_PACKAGE}.{entity["package"]}.mappings;

        {'\n'.join(sorted(imports))}

        public final class {entity["class"]}Mapper {{

            private {entity["class"]}Mapper() {{
            }}

            public static {entity["class"]} toEntity({entity["class"]}Request request) {{
                var entity = new {entity["class"]}();
                updateEntity(entity, request);
                return entity;
            }}

            public static void updateEntity({entity["class"]} entity, {entity["class"]}Request request) {{
        {'\n'.join(body_updates)}
            }}

            public static {entity["class"]}Resource toResource({entity["class"]} entity) {{
                return new {entity["class"]}Resource(
        {',\n'.join(resource_args)}
                );
            }}
        }}
    """


def render_repository(entity):
    return f"""
        package {BASE_PACKAGE}.{entity["package"]}.repositories;

        import {BASE_PACKAGE}.{entity["package"]}.entities.{entity["class"]};
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.UUID;

        public interface {entity["class"]}Repository extends JpaRepository<{entity["class"]}, UUID> {{
        }}
    """


def render_service(entity):
    imports = {
        f"import {BASE_PACKAGE}.{entity['package']}.dtos.{entity['class']}Request;",
        f"import {BASE_PACKAGE}.{entity['package']}.entities.{entity['class']};",
        f"import {BASE_PACKAGE}.{entity['package']}.mappings.{entity['class']}Mapper;",
        f"import {BASE_PACKAGE}.{entity['package']}.repositories.{entity['class']}Repository;",
        f"import {BASE_PACKAGE}.{entity['package']}.resources.{entity['class']}Resource;",
        "import com.korigo.api.shared.services.AbstractCrudService;",
        "import org.springframework.stereotype.Service;",
        "import org.springframework.transaction.annotation.Transactional;",
    }
    constructor_args = [f"{entity['class']}Repository repository"]
    assign_lines = []
    field_lines = [f"    private final {entity['class']}Repository repository;"]
    relation_lines = []

    for relation in entity["relations"]:
        repository_name = f"{relation['target_class']}Repository"
        variable_name = lower_first(repository_name)
        imports.add(
            f"import {BASE_PACKAGE}.{relation['target_package']}.repositories.{repository_name};"
        )
        constructor_args.append(f"{repository_name} {variable_name}")
        field_lines.append(f"    private final {repository_name} {variable_name};")
        assign_lines.append(f"        this.{variable_name} = {variable_name};")
        finder = "findRequired" if relation["required"] else "findOptional"
        setter_name = relation["name"][0].upper() + relation["name"][1:]
        relation_lines.append(
            f'        entity.set{setter_name}({finder}({variable_name}, request.{relation["name"]}Id(), "{relation["target_class"]}"));'
        )

    map_lines = [f"        {entity['class']}Mapper.updateEntity(entity, request);"]
    map_lines.extend(relation_lines)

    return f"""
        package {BASE_PACKAGE}.{entity["package"]}.services;

        {'\n'.join(sorted(imports))}

        @Service
        @Transactional
        public class {entity["class"]}Service extends AbstractCrudService<{entity["class"]}, {entity["class"]}Request, {entity["class"]}Resource> {{

        {'\n'.join(field_lines)}

            public {entity["class"]}Service({', '.join(constructor_args)}) {{
                super(repository, "{entity["class"]}");
                this.repository = repository;
        {'\n'.join(assign_lines) if assign_lines else '        '}
            }}

            @Override
            protected {entity["class"]} newEntity() {{
                return new {entity["class"]}();
            }}

            @Override
            protected void mapForCreate({entity["class"]} entity, {entity["class"]}Request request) {{
        {'\n'.join(map_lines)}
            }}

            @Override
            protected void mapForUpdate({entity["class"]} entity, {entity["class"]}Request request) {{
        {'\n'.join(map_lines)}
            }}

            @Override
            protected {entity["class"]}Resource toResource({entity["class"]} entity) {{
                return {entity["class"]}Mapper.toResource(entity);
            }}
        }}
    """


def render_controller(entity):
    return f"""
        package {BASE_PACKAGE}.{entity["package"]}.controllers;

        import {BASE_PACKAGE}.{entity["package"]}.dtos.{entity["class"]}Request;
        import {BASE_PACKAGE}.{entity["package"]}.resources.{entity["class"]}Resource;
        import {BASE_PACKAGE}.{entity["package"]}.services.{entity["class"]}Service;
        import com.korigo.api.shared.controllers.AbstractCrudController;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        @RestController
        @RequestMapping("/api/{entity["path"]}")
        public class {entity["class"]}Controller extends AbstractCrudController<{entity["class"]}Request, {entity["class"]}Resource> {{

            public {entity["class"]}Controller({entity["class"]}Service service) {{
                super(service);
            }}
        }}
    """


def render_shared_files():
    write_file(
        ROOT / "pom.xml",
        """
        <?xml version="1.0" encoding="UTF-8"?>
        <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
            <modelVersion>4.0.0</modelVersion>
            <parent>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-parent</artifactId>
                <version>4.0.4</version>
                <relativePath/>
            </parent>

            <groupId>com.korigo</groupId>
            <artifactId>korigo-api</artifactId>
            <version>0.0.1-SNAPSHOT</version>
            <name>korigo-api</name>
            <description>API CRUD Spring Boot pour KoriGo</description>

            <properties>
                <java.version>21</java.version>
            </properties>

            <dependencies>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-web</artifactId>
                </dependency>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-data-jpa</artifactId>
                </dependency>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-validation</artifactId>
                </dependency>
                <dependency>
                    <groupId>org.projectlombok</groupId>
                    <artifactId>lombok</artifactId>
                    <optional>true</optional>
                </dependency>
                <dependency>
                    <groupId>org.postgresql</groupId>
                    <artifactId>postgresql</artifactId>
                    <scope>runtime</scope>
                </dependency>
                <dependency>
                    <groupId>com.h2database</groupId>
                    <artifactId>h2</artifactId>
                    <scope>runtime</scope>
                </dependency>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-test</artifactId>
                    <scope>test</scope>
                </dependency>
            </dependencies>

            <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-compiler-plugin</artifactId>
                        <configuration>
                            <annotationProcessorPaths>
                                <path>
                                    <groupId>org.projectlombok</groupId>
                                    <artifactId>lombok</artifactId>
                                </path>
                            </annotationProcessorPaths>
                        </configuration>
                    </plugin>
                    <plugin>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-maven-plugin</artifactId>
                        <configuration>
                            <excludes>
                                <exclude>
                                    <groupId>org.projectlombok</groupId>
                                    <artifactId>lombok</artifactId>
                                </exclude>
                            </excludes>
                        </configuration>
                    </plugin>
                </plugins>
            </build>
        </project>
        """,
    )
    write_file(
        ROOT / "src" / "main" / "resources" / "application.properties",
        """
        spring.application.name=korigo-api

        spring.datasource.url=${DB_URL:jdbc:h2:mem:korigo;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE}
        spring.datasource.driver-class-name=${DB_DRIVER:org.h2.Driver}
        spring.datasource.username=${DB_USERNAME:sa}
        spring.datasource.password=${DB_PASSWORD:}

        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.open-in-view=false
        spring.jpa.show-sql=true
        spring.jpa.properties.hibernate.format_sql=true

        spring.h2.console.enabled=true
        spring.h2.console.path=/h2-console
        """,
    )
    write_file(
        BASE_DIR / "KoriGoApiApplication.java",
        """
        package com.korigo.api;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

        @SpringBootApplication
        public class KoriGoApiApplication {

            public static void main(String[] args) {
                SpringApplication.run(KoriGoApiApplication.class, args);
            }
        }
        """,
    )
    write_file(
        BASE_DIR / "shared" / "entities" / "BaseEntity.java",
        """
        package com.korigo.api.shared.entities;

        import jakarta.persistence.Column;
        import jakarta.persistence.Id;
        import jakarta.persistence.MappedSuperclass;
        import jakarta.persistence.PrePersist;
        import jakarta.persistence.PreUpdate;
        import lombok.Getter;
        import lombok.Setter;

        import java.time.LocalDateTime;
        import java.util.UUID;

        @Getter
        @Setter
        @MappedSuperclass
        public abstract class BaseEntity {

            @Id
            @Column(nullable = false, updatable = false)
            private UUID id;

            @Column(name = "created_at", nullable = false, updatable = false)
            private LocalDateTime createdAt;

            @Column(name = "updated_at", nullable = false)
            private LocalDateTime updatedAt;

            @PrePersist
            protected void onCreate() {
                if (id == null) {
                    id = UUID.randomUUID();
                }
                var now = LocalDateTime.now();
                createdAt = now;
                updatedAt = now;
            }

            @PreUpdate
            protected void onUpdate() {
                updatedAt = LocalDateTime.now();
            }
        }
        """,
    )
    write_file(
        BASE_DIR / "shared" / "exceptions" / "ResourceNotFoundException.java",
        """
        package com.korigo.api.shared.exceptions;

        public class ResourceNotFoundException extends RuntimeException {

            public ResourceNotFoundException(String message) {
                super(message);
            }
        }
        """,
    )
    write_file(
        BASE_DIR / "shared" / "resources" / "ApiErrorResource.java",
        """
        package com.korigo.api.shared.resources;

        import java.time.LocalDateTime;
        import java.util.List;

        public record ApiErrorResource(
            int status,
            String error,
            String message,
            List<String> details,
            LocalDateTime timestamp
        ) {
        }
        """,
    )
    write_file(
        BASE_DIR / "shared" / "config" / "GlobalExceptionHandler.java",
        """
        package com.korigo.api.shared.config;

        import com.korigo.api.shared.exceptions.ResourceNotFoundException;
        import com.korigo.api.shared.resources.ApiErrorResource;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.validation.FieldError;
        import org.springframework.web.bind.MethodArgumentNotValidException;
        import org.springframework.web.bind.annotation.ExceptionHandler;
        import org.springframework.web.bind.annotation.RestControllerAdvice;

        import java.time.LocalDateTime;
        import java.util.List;

        @RestControllerAdvice
        public class GlobalExceptionHandler {

            @ExceptionHandler(ResourceNotFoundException.class)
            public ResponseEntity<ApiErrorResource> handleNotFound(ResourceNotFoundException exception) {
                return build(HttpStatus.NOT_FOUND, exception.getMessage(), List.of());
            }

            @ExceptionHandler(MethodArgumentNotValidException.class)
            public ResponseEntity<ApiErrorResource> handleValidation(MethodArgumentNotValidException exception) {
                List<String> details = exception.getBindingResult()
                    .getAllErrors()
                    .stream()
                    .map(error -> error instanceof FieldError fieldError
                        ? fieldError.getField() + ": " + fieldError.getDefaultMessage()
                        : error.getDefaultMessage())
                    .toList();
                return build(HttpStatus.BAD_REQUEST, "Validation error", details);
            }

            @ExceptionHandler(Exception.class)
            public ResponseEntity<ApiErrorResource> handleGeneric(Exception exception) {
                return build(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), List.of());
            }

            private ResponseEntity<ApiErrorResource> build(HttpStatus status, String message, List<String> details) {
                return ResponseEntity.status(status).body(
                    new ApiErrorResource(
                        status.value(),
                        status.getReasonPhrase(),
                        message,
                        details,
                        LocalDateTime.now()
                    )
                );
            }
        }
        """,
    )
    write_file(
        BASE_DIR / "shared" / "services" / "CrudOperations.java",
        """
        package com.korigo.api.shared.services;

        import java.util.List;
        import java.util.UUID;

        public interface CrudOperations<REQ, RES> {

            RES create(REQ request);

            RES update(UUID id, REQ request);

            RES findById(UUID id);

            List<RES> findAll();

            void delete(UUID id);
        }
        """,
    )
    write_file(
        BASE_DIR / "shared" / "services" / "AbstractCrudService.java",
        """
        package com.korigo.api.shared.services;

        import com.korigo.api.shared.entities.BaseEntity;
        import com.korigo.api.shared.exceptions.ResourceNotFoundException;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;
        import java.util.UUID;

        @Transactional
        public abstract class AbstractCrudService<E extends BaseEntity, REQ, RES> implements CrudOperations<REQ, RES> {

            private final JpaRepository<E, UUID> repository;
            private final String resourceName;

            protected AbstractCrudService(JpaRepository<E, UUID> repository, String resourceName) {
                this.repository = repository;
                this.resourceName = resourceName;
            }

            @Override
            public RES create(REQ request) {
                E entity = newEntity();
                mapForCreate(entity, request);
                return toResource(repository.save(entity));
            }

            @Override
            public RES update(UUID id, REQ request) {
                E entity = getEntity(id);
                mapForUpdate(entity, request);
                return toResource(repository.save(entity));
            }

            @Override
            @Transactional(readOnly = true)
            public RES findById(UUID id) {
                return toResource(getEntity(id));
            }

            @Override
            @Transactional(readOnly = true)
            public List<RES> findAll() {
                return repository.findAll().stream().map(this::toResource).toList();
            }

            @Override
            public void delete(UUID id) {
                repository.delete(getEntity(id));
            }

            protected E getEntity(UUID id) {
                return repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(resourceName + " not found for id " + id));
            }

            protected <T> T findRequired(JpaRepository<T, UUID> relationRepository, UUID id, String resource) {
                if (id == null) {
                    throw new ResourceNotFoundException(resource + " id is required");
                }
                return relationRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(resource + " not found for id " + id));
            }

            protected <T> T findOptional(JpaRepository<T, UUID> relationRepository, UUID id, String resource) {
                if (id == null) {
                    return null;
                }
                return relationRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(resource + " not found for id " + id));
            }

            protected abstract E newEntity();

            protected abstract void mapForCreate(E entity, REQ request);

            protected abstract void mapForUpdate(E entity, REQ request);

            protected abstract RES toResource(E entity);
        }
        """,
    )
    write_file(
        BASE_DIR / "shared" / "controllers" / "AbstractCrudController.java",
        """
        package com.korigo.api.shared.controllers;

        import com.korigo.api.shared.services.CrudOperations;
        import jakarta.validation.Valid;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.DeleteMapping;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.PutMapping;
        import org.springframework.web.bind.annotation.RequestBody;

        import java.util.List;
        import java.util.UUID;

        public abstract class AbstractCrudController<REQ, RES> {

            private final CrudOperations<REQ, RES> service;

            protected AbstractCrudController(CrudOperations<REQ, RES> service) {
                this.service = service;
            }

            @PostMapping
            public ResponseEntity<RES> create(@Valid @RequestBody REQ request) {
                return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
            }

            @PutMapping("/{id}")
            public RES update(@PathVariable UUID id, @Valid @RequestBody REQ request) {
                return service.update(id, request);
            }

            @GetMapping("/{id}")
            public RES findById(@PathVariable UUID id) {
                return service.findById(id);
            }

            @GetMapping
            public List<RES> findAll() {
                return service.findAll();
            }

            @DeleteMapping("/{id}")
            public ResponseEntity<Void> delete(@PathVariable UUID id) {
                service.delete(id);
                return ResponseEntity.noContent().build();
            }
        }
        """,
    )
    write_file(
        SRC_TEST / "com" / "korigo" / "api" / "KoriGoApiApplicationTests.java",
        """
        package com.korigo.api;

        import org.junit.jupiter.api.Test;
        import org.springframework.boot.test.context.SpringBootTest;

        @SpringBootTest
        class KoriGoApiApplicationTests {

            @Test
            void contextLoads() {
            }
        }
        """,
    )

    old_main = SRC_MAIN / "KoriGo_api"
    if old_main.exists():
        for file in sorted(old_main.rglob("*.java"), reverse=True):
            file.unlink()

    old_test = SRC_TEST / "KoriGo_api"
    if old_test.exists():
        for file in sorted(old_test.rglob("*.java"), reverse=True):
            file.unlink()


def render_entities():
    for entity in ENTITIES:
        module_dir = BASE_DIR / entity["package"]
        write_file(module_dir / "entities" / f"{entity['class']}.java", render_entity(entity))
        write_file(module_dir / "dtos" / f"{entity['class']}Request.java", render_request(entity))
        write_file(module_dir / "resources" / f"{entity['class']}Resource.java", render_resource(entity))
        write_file(module_dir / "mappings" / f"{entity['class']}Mapper.java", render_mapper(entity))
        write_file(module_dir / "repositories" / f"{entity['class']}Repository.java", render_repository(entity))
        write_file(module_dir / "services" / f"{entity['class']}Service.java", render_service(entity))
        write_file(module_dir / "controllers" / f"{entity['class']}Controller.java", render_controller(entity))


if __name__ == "__main__":
    render_shared_files()
    render_entities()
