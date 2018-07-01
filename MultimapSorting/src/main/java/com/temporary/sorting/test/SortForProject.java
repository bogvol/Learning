package com.temporary.sorting.test;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

import java.util.Map;

public class SortForProject {

    public static void main(String[] args) {
        Multimap<String, String> initialDocumentsSet = HashMultimap.create();
        initialDocumentsSet.put("Driver Licence", "5432164654");
        initialDocumentsSet.put("Blablabla", "99999999");
        initialDocumentsSet.put("Passport", "112121212");
        initialDocumentsSet.put("Tax ID", "2323232");
        initialDocumentsSet.put("Other", "56565655");

        for (Map.Entry<String, String> initDocument : initialDocumentsSet.entries()) {
            System.out.println("{" + initDocument.getKey() + " : " + initDocument.getValue() + "}");
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++");
        Multimap<String, String> initialDocumentsSet1 = HashMultimap.create();
        for (Map.Entry<String, String> sortDocument : getPriorityDocument(initialDocumentsSet).entries()) {
            System.out.println("{" + sortDocument.getKey() + " : " + sortDocument.getValue() + "}");
        }

    }

    public static Multimap<String, String> getPriorityDocument(Multimap<String, String> documents) {
        Multimap<Documents, String> sortedDocumentsSet = MultimapBuilder.treeKeys().arrayListValues().build();
        for (Map.Entry<String, String> document : documents.entries()) {
            if (document.getKey().equals(Documents.PASSPORT.getUiValue())) {
                sortedDocumentsSet.put(Documents.PASSPORT, document.getValue());
            } else if (document.getKey().equals(Documents.TAX_ID.getUiValue())) {
                sortedDocumentsSet.put(Documents.TAX_ID, document.getValue());
            } else if (document.getKey().equals(Documents.DRIVER_LICENCE.getUiValue())) {
                sortedDocumentsSet.put(Documents.DRIVER_LICENCE, document.getValue());
            } else if (document.getKey().equals(Documents.OTHER.getUiValue())) {
                sortedDocumentsSet.put(Documents.OTHER, document.getValue());
            }
        }

        Multimap<String, String> convertedSortedDocumentsSet = LinkedListMultimap.create();
        if (!sortedDocumentsSet.isEmpty()) {
            for (Map.Entry<Documents, String> document : sortedDocumentsSet.entries()) {
                convertedSortedDocumentsSet.put(document.getKey().getUiValue(), document.getValue());
            }
        } else {
            convertedSortedDocumentsSet.put("","");
        }
        return convertedSortedDocumentsSet;
}


public static enum Documents {
    PASSPORT("Passport"),
    TAX_ID("Tax ID"),
    DRIVER_LICENCE("Driver Licence"),
    OTHER("Other");

    private String uiValue;

    Documents(String uiValue) {
        this.uiValue = uiValue;
    }

    public String getUiValue() {
        return uiValue;
    }
}

}
