# WS-Factory
Web Service - SOAP - Java JAX-WS

## Deskripsi
WS-Factory merupakan web service yang berlaku sebagai pabrik untuk memproduksi coklat. Web Service ini dibuat menggunakan Java JAX-WS.

## Basis Data yang Digunakan
Web Service ini menggunakan basisdata MySQL yang skemanya terdapat pada [data/create.txt](../create.txt). Pengguna juga dapat mengimport database yang ada pada [data/wwfactory.sql](../wwfactory.sql) sebagai data awal.

## Cara Menjalankan Web Service
1. Clone repository ini
2. Jalankan command `mvn clean install` di dalam reppository
3. Jalankan command `mvn tomcat7:run`
4. Buka [localhost:8081/hello](http://localhost:8081)

## Author
13518012 | Muhammad Hasan \
13518019 | Muhammad Zunan Alfikri \
13518022 | Fabian Zhafransyah