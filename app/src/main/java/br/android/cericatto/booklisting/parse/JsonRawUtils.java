package br.android.cericatto.booklisting.parse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.android.cericatto.booklisting.model.AccessInfo;
import br.android.cericatto.booklisting.model.BookItem;
import br.android.cericatto.booklisting.model.EPub;
import br.android.cericatto.booklisting.model.ImageLink;
import br.android.cericatto.booklisting.model.IndustryIdentifier;
import br.android.cericatto.booklisting.model.Pdf;
import br.android.cericatto.booklisting.model.ReadingMode;
import br.android.cericatto.booklisting.model.SaleInfo;
import br.android.cericatto.booklisting.model.SearchInfo;
import br.android.cericatto.booklisting.model.VolumeInfo;
import br.android.cericatto.booklisting.utils.Utils;

/**
 * JsonRawUtils.java.
 *
 * @author Rodrigo Cericatto
 * @since Sep 8, 2016
 */
public class JsonRawUtils {

    //--------------------------------------------------
    // Json Parsing General
    //--------------------------------------------------

    public static List<BookItem> parseBookData(String data) {
        List<BookItem> list = null;
        try {
            JSONObject rootJsonObject = new JSONObject(data);
            String items = parseString(rootJsonObject, "items");
            JSONArray jsonItemsArray = new JSONArray(items);
            list = getBookItemList(jsonItemsArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static List<BookItem> getBookItemList(JSONArray jsonItemsArray) {
        List<BookItem> list = new ArrayList<>();
        for (int i = 0; i < jsonItemsArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonItemsArray.getJSONObject(i);
                String kind = parseString(jsonObject, "kind");
                String id = parseString(jsonObject, "id");
                String etag = parseString(jsonObject, "etag");
                String selfLink = parseString(jsonObject, "selfLink");
                VolumeInfo volumeInfo = getVolumeInfo(jsonObject);
                SaleInfo saleInfo = getSaleInfo(jsonObject);
                AccessInfo accessInfo = getAccessInfo(jsonObject);
                SearchInfo searchInfo = getSearchInfo(jsonObject);
                BookItem item = new BookItem(kind, id, etag, selfLink, volumeInfo, saleInfo,
                        accessInfo, searchInfo);
                list.add(item);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private static VolumeInfo getVolumeInfo(JSONObject jsonObject) {
        String data = parseString(jsonObject, "volumeInfo");
        VolumeInfo volumeInfo = null;
        try {
            JSONObject volumeInfoJsonObject = new JSONObject(data);

            String title = parseString(volumeInfoJsonObject, "title");

            String authorsString = parseString(volumeInfoJsonObject, "authors");
            List<String> authors = getAuthorList(authorsString);

            String publisher = parseString(volumeInfoJsonObject, "publisher");
            String publishedDate = parseString(volumeInfoJsonObject, "publishedDate");
            String description = parseString(volumeInfoJsonObject, "description");

            String industryIdentifiersString = parseString(volumeInfoJsonObject, "industryIdentifiers");
            List<IndustryIdentifier> industryIdentifiers = getIndustryIdentifierList(industryIdentifiersString);

            String readingModesString = parseString(volumeInfoJsonObject, "readingModes");
            ReadingMode readingModes = Utils.fromJson(readingModesString, ReadingMode.class);

            Integer pageCount = parseInteger(volumeInfoJsonObject, "pageCount");
            String printType = parseString(volumeInfoJsonObject, "printType");

            String categories = parseString(volumeInfoJsonObject, "categories");

            Integer averageRating = parseInteger(volumeInfoJsonObject, "averageRating");
            Integer ratingsCount = parseInteger(volumeInfoJsonObject, "ratingsCount");

            String maturityRating = parseString(volumeInfoJsonObject, "maturityRating");
            Boolean allowAnonLogging = parseBoolean(volumeInfoJsonObject, "allowAnonLogging");

            String contentVersion = parseString(volumeInfoJsonObject, "contentVersion");

            String imageLinksString = parseString(volumeInfoJsonObject, "imageLinks");
            ImageLink imageLinks = Utils.fromJson(imageLinksString, ImageLink.class);

            String language = parseString(volumeInfoJsonObject, "language");
            String previewLink = parseString(volumeInfoJsonObject, "previewLink");
            String infoLink = parseString(volumeInfoJsonObject, "infoLink");
            String canonicalVolumeLink = parseString(volumeInfoJsonObject, "canonicalVolumeLink");

            volumeInfo = new VolumeInfo(title, authors, publisher, publishedDate, description,
                industryIdentifiers, readingModes, pageCount, printType, categories, averageRating,
                ratingsCount, maturityRating, allowAnonLogging, contentVersion, imageLinks, language,
                previewLink, infoLink, canonicalVolumeLink);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return volumeInfo;
    }

    private static SaleInfo getSaleInfo(JSONObject jsonObject) {
        String data = parseString(jsonObject, "saleInfo");
        SaleInfo saleInfo = null;
        try {
            JSONObject saleInfoJsonObject = new JSONObject(data);

            String country = parseString(saleInfoJsonObject, "country");
            String saleability = parseString(saleInfoJsonObject, "saleability");
            Boolean isEbook = parseBoolean(saleInfoJsonObject, "isEbook");

            saleInfo = new SaleInfo(country, saleability, isEbook);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return saleInfo;
    }

    private static AccessInfo getAccessInfo(JSONObject jsonObject) {
        String data = parseString(jsonObject, "accessInfo");
        AccessInfo accessInfo = null;
        try {
            JSONObject accessInfoJsonObject = new JSONObject(data);

            String country = parseString(accessInfoJsonObject, "country");
            String viewability = parseString(accessInfoJsonObject, "viewability");
            Boolean embeddable = parseBoolean(accessInfoJsonObject, "embeddable");
            Boolean publicDomain = parseBoolean(accessInfoJsonObject, "publicDomain");
            String textToSpeechPermission = parseString(accessInfoJsonObject, "textToSpeechPermission");

            String ePubString = parseString(accessInfoJsonObject, "epub");
            EPub epub = Utils.fromJson(ePubString, EPub.class);

            String pdfString = parseString(accessInfoJsonObject, "pdf");
            Pdf pdf = Utils.fromJson(pdfString, Pdf.class);

            String webReaderLink = parseString(accessInfoJsonObject, "webReaderLink");
            String accessViewStatus = parseString(accessInfoJsonObject, "accessViewStatus");
            Boolean quoteSharingAllowed = parseBoolean(accessInfoJsonObject, "quoteSharingAllowed");

            accessInfo = new AccessInfo(country, viewability, embeddable, publicDomain,
                textToSpeechPermission, epub, pdf, webReaderLink, accessViewStatus, quoteSharingAllowed);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return accessInfo;
    }

    private static SearchInfo getSearchInfo(JSONObject jsonObject) {
        String data = parseString(jsonObject, "searchInfo");
        SearchInfo searchInfo = null;
        try {
            JSONObject searchInfoJsonObject = new JSONObject(data);

            String textSnippet = parseString(searchInfoJsonObject, "textSnippet");
            searchInfo = new SearchInfo(textSnippet);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return searchInfo;
    }

    private static List<String> getAuthorList(String data) {
        String[] parts = data.split(",");
        List<String> list = new ArrayList<>();
        for (String item: parts) {
            list.add(item);
        }
        return list;
    }

    private static List<IndustryIdentifier> getIndustryIdentifierList(String data) {
        List<IndustryIdentifier> list = new ArrayList<>();
        JSONArray jsonItemsArray;
        try {
            jsonItemsArray = new JSONArray(data);
            for (int i = 0; i < jsonItemsArray.length(); i++) {
                JSONObject jsonObject = jsonItemsArray.getJSONObject(i);
                String type = parseString(jsonObject, "type");
                String identifier = parseString(jsonObject, "identifier");
                list.add(new IndustryIdentifier(type, identifier));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    //--------------------------------------------------
    // Json Parsing Primitives
    //--------------------------------------------------

    public static Integer parseInteger(JSONObject jsonObject, String key) {
        Integer value = 0;
        try {
            value = jsonObject.getInt(key);
            if (value == null) {
                value = 0;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static Long parseLong(JSONObject jsonObject, String key) {
        Long value = 0l;
        try {
            value = jsonObject.getLong(key);
            if (value == null) {
                value = 0l;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String parseString(JSONObject jsonObject, String key) {
        String value = "";
        try {
            value = jsonObject.getString(key);
            if (value == null) {
                value = "";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static Boolean parseBoolean(JSONObject jsonObject, String key) {
        Boolean value = false;
        try {
            value = jsonObject.getBoolean(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }
}