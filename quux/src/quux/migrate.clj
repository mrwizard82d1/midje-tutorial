(ns quux.migrate)

(def migrate
  (fn [left & args]
    (let [_ (println "left" left)
          right (last args)
          _ (println "right" right)
          keys (drop-last args)
          _ (println "keys" keys)
          kvs (->> keys
                   (map left)
                   (filter (complement nil?))
                   (map vector keys)
                   (flatten))
          _ (println "kvs" kvs)]
      {:new-left (apply dissoc left keys)
       :clashes #{}
       :new-right (if (empty? kvs)
                    right
                    (apply assoc right kvs))})))
