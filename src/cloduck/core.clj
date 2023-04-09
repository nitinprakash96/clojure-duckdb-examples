(ns cloduck.core
  (:require [next.jdbc :as jdbc]))

(def pragma-list
  {:database-list "database_list"
   :show-tables "show_tables"
   :show-tables-expanded "show_tables_expanded"
   :functions "functions"
   :database-size "database_size"
   :collations "collations"
   :version "version"
   })

(defn pragma-stmt [key]
  (str "PRAGMA " key))

(defn ds []
  (jdbc/get-datasource {:dbtype "duckdb" :dbname "file.db" :host :none}))

(defn create-table []
  (with-open [conn (jdbc/get-connection (ds))]
    (jdbc/execute! conn ["CREATE TABLE test (a INTEGER, b VARCHAR)"])))

(defn run-pragma [key]
  (with-open [conn (jdbc/get-connection (ds))]
    (first (jdbc/execute! conn [(pragma-stmt (key pragma-list))]))))
