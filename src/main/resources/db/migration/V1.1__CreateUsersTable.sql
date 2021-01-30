
CREATE TABLE "users" (
    "username"	VARCHAR(256),
    "password"	VARCHAR(256)
);

CREATE UNIQUE INDEX "idx_users_usernames"
ON "users" ("username");
