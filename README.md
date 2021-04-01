# Spring Boot + Spring Security example using @PreAuthorize

This example projects shows how to use the `@PreAuthorize` annotation with in your REST Controllers.

You can read about how this application was created in [Spring Method Security with PreAuthorize](). Feel free to copy any code in this project for your own use in accordance with the [Apache license](LICENSE).

**Prerequisites**: Java 11.

To run the application you will need to update the [`src/main/resources/application.yml`](src/main/resources/application.yml) file with your Okta OAuth2 configuration (see blog post above), then run:

```bash
./gradlew bootRun
```

Then browse to `http://localhost:8080`
