
CREATE TABLE "users" (
    "username"	VARCHAR(256) NOT NULL,
    "password"	VARCHAR(256),
    "first_name" VARCHAR(128),
    "last_name" VARCHAR(128)
);

CREATE UNIQUE INDEX "idx_users_usernames"
ON "users" ("username");
