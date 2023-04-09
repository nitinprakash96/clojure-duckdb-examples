# cloduck

Just laying down some examples on how to use duckdb with clojure.

## Usage

```clojure
cloduck.core> (use 'cloduck.core :reload)
nil
cloduck.core> (run-pragma :version)
{:library_version "v0.7.1", :source_id "b00b93f0b1"}
cloduck.core> (run-pragma :database-size)
{:free_blocks 0,
 :memory_usage "0 bytes",
 :database_name "file",
 :wal_size "0 bytes",
 :block_size 262144,
 :memory_limit "6.8GB",
 :total_blocks 3,
 :used_blocks 3,
 :database_size "786KB"}
cloduck.core>
```
