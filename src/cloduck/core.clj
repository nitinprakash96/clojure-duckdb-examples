(ns cloduck.core
  (:require [next.jdbc :as jdbc]))


(defn ds []
  (jdbc/get-datasource {:dbtype "duckdb" :dbname "file.db" :host :none}))

(defn create-table []
  (with-open [conn (jdbc/get-connection (ds))]
    (jdbc/execute! conn ["CREATE TABLE test (a INTEGER, b VARCHAR)"])))

(defn run-pragma [pragma-stmt]
  (with-open [conn (jdbc/get-connection (ds))]
    (first (jdbc/execute! conn [(str "PRAGMA " pragma-stmt)]))))
