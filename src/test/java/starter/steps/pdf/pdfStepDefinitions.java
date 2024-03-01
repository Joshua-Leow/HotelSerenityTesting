package starter.steps.pdf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import starter.pages.API.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;

public class pdfStepDefinitions {

    @Given("{actor} verifies PDF file {string} to {string}")
    public void userIVerifiesPdfFiles(Actor actor, String filePath1, String filePath2) {
        String text1;
        try {
            text1 = extractTextFromPDF(filePath1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String text2;
        try {
            text2 = extractTextFromPDF(filePath2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        double similarity = calculateSimilarity(text1, text2);
        actor.remember("similarity_percentage", similarity);
        System.out.printf("Similarity: %.2f%%\n", similarity * 100);

        reportDifferences(text1, text2);
    }

    @Then("{actor} sees PDF file similarity should be above 90%")
    public void userShouldSeeTheResponseAuthenticatedSuccessfully(Actor actor) {
        Double similarity = actor.recall("similarity_percentage");
        boolean above90Percent = similarity > 0.9; // 90%
        if (above90Percent) {
            System.out.println("Above 90% PASSED");
            System.out.println("similarity = " + similarity);
            assertThat(true).isTrue();
        }
        else {
            System.out.println("Above 90% FAILED");
            System.out.println("similarity = " + similarity);
            assertThat(false).isTrue();
        }
    }

    private static String extractTextFromPDF(String filePath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }

    private static double calculateSimilarity(String text1, String text2) {
        // Similarity calculation (as before)
        String[] words1 = text1.split("\\s+");
        String[] words2 = text2.split("\\s+");

        int commonCount = 0;
        for (String word1 : words1) {
            for (String word2 : words2) {
                if (word1.equalsIgnoreCase(word2)) {
                    commonCount++;
                    break;
                }
            }
        }

        return 2.0 * commonCount / (words1.length + words2.length);
    }

    private static void reportDifferences(String text1, String text2) {
        // Split the texts into arrays of words
        String[] words1 = text1.toLowerCase().split("\\s+");
        String[] words2 = text2.toLowerCase().split("\\s+");

        // Create sets from the arrays
        Set<String> set1 = new HashSet<>(Arrays.asList(words1));
        Set<String> set2 = new HashSet<>(Arrays.asList(words2));

        // Find words unique to each set
        Set<String> uniqueTo1 = new HashSet<>(set1);
        uniqueTo1.removeAll(set2);

        Set<String> uniqueTo2 = new HashSet<>(set2);
        uniqueTo2.removeAll(set1);

        System.out.println("Unique to PDF 1:");
        uniqueTo1.forEach(System.out::println);

        System.out.println("\nUnique to PDF 2:");
        uniqueTo2.forEach(System.out::println);
    }
}
