

CREATE TABLE "humidity_info" (
	"humidity_info_id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"relative_humidity_percent" REAL DEFAULT 10.0, -- 0...100.0%
        "date_of_registration" DATETIME DEFAULT CURRENT_TIMESTAMP, -- YYYY-mm-dd

        "place_id" INTEGER NOT NULL,

        FOREIGN KEY("place_id") REFERENCES place("place_id")
);


