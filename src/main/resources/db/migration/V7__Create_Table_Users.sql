CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY ,
  user_name TEXT DEFAULT NULL UNIQUE,
  full_name TEXT DEFAULT NULL,
  password TEXT DEFAULT NULL,
  account_non_expired BIT DEFAULT NULL,
  account_non_locked BIT DEFAULT NULL,
  credentials_non_expired BIT DEFAULT NULL,
  enabled BIT DEFAULT NULL
);