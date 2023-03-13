CREATE TABLE IF NOT EXISTS user_permission (
  id_user INT NOT NULL references users(id),
  id_permission INT NOT NULL references permission(id)
                                           )