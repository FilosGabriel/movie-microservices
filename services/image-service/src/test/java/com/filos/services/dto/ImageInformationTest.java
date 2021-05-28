package com.filos.services.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({ @Tag("image-info") })
@DisplayName("Given a information about a image")
public class ImageInformationTest {

    private final ImageInformation subject = new ImageInformation("image.jpg", 100, 100);

    @Test
    @DisplayName("it should extract correctly  image id")
    public void getIfImage() {
        Assertions.assertEquals(subject.getId(), "image");
    }

    @Test
    @DisplayName("it should get name for save correctly")
    public void getNameInCaseOfSaving() {
        Assertions.assertEquals(subject.nameForSave(), "100x100.jpg");
    }

    @Test
    @DisplayName("it should extract correctly search value")
    public void searchName() {
        Assertions.assertArrayEquals(subject.searchName(), new String[] { "image", "100x100.jpg" });
    }

    @Test
    @DisplayName("it should decide correctly if image is webp")
    public void isWebp() {
        Assertions.assertFalse(subject.asWebp());
    }

    @Test
    @DisplayName("it should return debug values")
    public void debug() {
        Assertions.assertArrayEquals(subject.debug(), new Object[] {
                "image.jpg", 100, 100
        });
    }

}