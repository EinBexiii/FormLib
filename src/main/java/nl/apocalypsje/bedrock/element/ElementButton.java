package nl.apocalypsje.bedrock.element;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElementButton extends Element {

    private String buttonText;
    private ImageType imageType;
    private String imageData;

    public ElementButton(@NotNull String elementId) {
        super(ElementType.BUTTON);
        this.elementId = elementId;
    }

    public ElementButton(@NotNull String elementId, @Nullable String buttonText) {
        super(ElementType.BUTTON);
        this.elementId = elementId;
        this.buttonText = buttonText;
    }

    public ElementButton(@NotNull String elementId, @Nullable String buttonText, @Nullable ImageType imageType, @Nullable String imageData) {
        super(ElementType.BUTTON);
        this.elementId = elementId;
        this.buttonText = buttonText;
        this.imageType = imageType;
        this.imageData = imageData;
    }

    @Nullable
    public String getButtonText() {
        return this.buttonText;
    }

    @NotNull
    public ElementButton text(@Nullable String buttonText) {
        this.buttonText = buttonText;
        return this;
    }

    @Nullable
    public ImageType getImageType() {
        return this.imageType;
    }

    @NotNull
    public ElementButton imageType(@Nullable ImageType imageType) {
        this.imageType = imageType;
        return this;
    }

    @Nullable
    public String getImageData() {
        return this.imageData;
    }

    @NotNull
    public ElementButton imageData(@Nullable String imageData) {
        this.imageData = imageData;
        return this;
    }

    @Override
    @NotNull
    public JsonObject getJsonData() {
        this.jsonObject.addProperty("text", this.buttonText != null ? this.buttonText : "");
        if (this.imageType != null && this.imageData != null) {
            JsonObject imageObject = new JsonObject();
            imageObject.addProperty("type", this.imageType.getTypeString());
            imageObject.addProperty("data", this.imageData);
            this.jsonObject.add("image", imageObject);
        }
        return this.jsonObject;
    }

    @Override
    public String toString() {
        return "ElementButton{" +
                "buttonText='" + this.buttonText + '\'' +
                ", imageType=" + this.imageType +
                ", imageData='" + this.imageData + '\'' +
                ", jsonObject=" + this.jsonObject +
                ", elementId='" + this.elementId + '\'' +
                ", elementType=" + this.elementType +
                '}';
    }

    public enum ImageType {
        /**
         * Remote URL
         */
        URL("url"),
        /**
         * Path on the server file system
         */
        FILE("path");

        private String typeString;

        ImageType(@NotNull String typeString) {
            this.typeString = typeString;
        }

        @NotNull
        public String getTypeString() {
            return this.typeString;
        }

        @Override
        public String toString() {
            return "ImageType." + this.name() + "{" +
                    "typeString='" + this.typeString + '\'' +
                    '}';
        }
    }
}