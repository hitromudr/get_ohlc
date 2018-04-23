scalaVersion := "2.12.5"
sbt.version=1.1.4

run 
> sbt test gatling:test

gatling results are in 
[project]/target/gatling/candletest-4-load-gatling-[tag]/index.html