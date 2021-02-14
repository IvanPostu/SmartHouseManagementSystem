
CREATE TABLE "users" (
    "username"	VARCHAR(256) NOT NULL,
    "first_name" VARCHAR(128),
    "last_name" VARCHAR(128),
    "password" VARCHAR(256),
    "hash_algorithm" VARCHAR(64),

    PRIMARY KEY("username")
);

CREATE UNIQUE INDEX "idx_users_usernames"
ON "users" ("username");
