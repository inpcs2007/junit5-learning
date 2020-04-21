package cn.inpcs.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.UUID;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.stubbing.StubImport.stubImport;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Wire mock j unit 5 test.
 *
 * @author inpcs
 * @version 1.0
 * @date 2020 -04-21 22:29:32
 */
public class WireMockJUnit5Test {

    private WireMockServer wireMockServer;

    /**
     * Sets .
     */
    @BeforeEach
    public void setup() {
        wireMockServer = new WireMockServer(8090);
        wireMockServer.start();
    }

    /**
     * Teardown.
     */
    @AfterEach
    public void teardown() {
        wireMockServer.stop();
    }

    /**
     * Edit stub.
     */
    @Test
    public void edit_Stub() {

        // init uuid
        UUID uuid = java.util.UUID.randomUUID();

        // init stub for hello wiremock!
        wireMockServer.stubFor(get(urlEqualTo("/wiremock-sapmel"))
                .withId(uuid).willReturn(aResponse().withBody("hello wiremock!")));
        Response response = given().when().get("http://localhost:8090/wiremock-sapmel");
        assertEquals("hello wiremock!", response.asString());

        // editstub for world wiremock!
        wireMockServer.editStub(get(urlEqualTo("/wiremock-sapmel"))
                .withId(uuid).willReturn(aResponse().withBody("world wiremock!")));

        response = given().when().get("http://localhost:8090/wiremock-sapmel");
        assertEquals("world wiremock!", response.asString());

    }


    /**
     * Pars json data.
     *
     * @throws IOException the io exception
     */
    @Test
    public void pars_json_data() throws IOException {

        StringBuffer jsonSB = redadJsonFile("src/test/resources/__files/glossary.json", Charsets.UTF_8);
        wireMockServer.stubFor(get(urlEqualTo("/wiremock-sapmel"))
                .willReturn(aResponse().withBody(jsonSB.toString())));

        String title = given()
                .when()
                .get("http://localhost:8090/wiremock-sapmel")
                .getBody().jsonPath().get("glossary.title").toString();

        assertEquals("example glossary", title);

    }

    /**
     * Remove sub mapping.
     */
    @Test
    public void remove_sub_mapping() {

        wireMockServer.stubFor(get(urlEqualTo("/wiremock-sapmel"))
                .willReturn(aResponse().withStatus(200)));

        given().
                when().
                get("http://localhost:8090/wiremock-sapmel").
                then().
                assertThat().statusCode(200);
        wireMockServer.removeStub(get(urlEqualTo("/wiremock-sapmel")));

        given().
                when().
                get("http://localhost:8090/wiremock-sapmel").
                then().
                assertThat().statusCode(404);

    }

    /**
     * Status code positive.
     */
    @Test
    public void status_code_positive() {

        wireMockServer.stubFor(get(WireMock.urlEqualTo("/wiremock-sapmel"))
                .willReturn(WireMock.aResponse().withStatus(200)));

        given().
                when().
                get("http://localhost:8090/wiremock-sapmel").
                then().
                assertThat().statusCode(200);
    }

    /**
     * Status code negative.
     */
    @Test
    public void status_code_negative() {
        wireMockServer.stubFor(get(WireMock.urlEqualTo("/wiremock-sapmel"))
                .willReturn(WireMock.aResponse().withStatus(404)));
        given().
                when().
                get("http://localhost:8090/wire-sapmel").
                then().
                assertThat().statusCode(404);
    }


    /**
     * Multiple stubs.
     */
    @Test
    public void multiple_stubs() {
        wireMockServer = new WireMockServer(8099);
        wireMockServer.start();

        WireMock.configureFor("localhost", 8099);

        WireMock.importStubs(stubImport()
                .stub(get("/one").willReturn(aResponse().withBody("One Body")))
                .stub(post("/two").willReturn(aResponse().withBody("two Body content")))
                .stub(put("/three").willReturn(aResponse().withBody("Three Body")))
                .ignoreExisting()
                .deleteAllExistingStubsNotInImport());

        Response response = given().when().get("http://localhost:8099/one");
        assertEquals(response.getBody().asString(),"One Body");;

        response = given().when().post("http://localhost:8099/two");
        assertEquals(response.getBody().asString(),"two Body content");;

        response = given().when().put("http://localhost:8099/three");
        assertEquals(response.getBody().asString(),"Three Body");;
        wireMockServer.stop();
    }

    private StringBuffer redadJsonFile(String filePath, Charset charset) throws IOException {

        String line;
        StringBuffer sb = new StringBuffer();

        BufferedReader reader = Files.newReader(new File(filePath), charset);

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb;
    }
}