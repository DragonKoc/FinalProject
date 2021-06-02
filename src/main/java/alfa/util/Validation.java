package alfa.util;

import alfa.exception.*;

public class Validation {
    public static String validateNameBook(String name) {
        if (name != null && !name.equals("")) {
            return name;
        } else {
            throw new BookNameValidateException("Set book name is not valid.");
        }
    }

    public static String validateAuthorBook(String author){
        if (author != null && !author.equals("")) {
            return author;
        } else {
            throw new BookAuthorValidateException("Set book author is not valid.");
        }
    }

    public static String validatePublishBook(String publish){
        if (publish != null && !publish.equals("")) {
            return publish;
        } else {
            throw new BookPublishValidateException("Set book publish is not valid.");
        }
    }

    public static Integer validateYearBook(String year){
        try {
            Integer varYear = Integer.parseInt(year);
            if (varYear != null && Integer.MIN_VALUE < varYear && varYear < Integer.MAX_VALUE) {
            return varYear;
            } else {
                throw new BookYearValidateException("Set book year is not valid.");
            }
        } catch (Exception e) {
            throw new BookYearValidateException("Set book year is not valid.");
        }
    }


    public static Integer validateCountPagesBook(String countPages){
        try{
            Integer varCountPage = Integer.parseInt(countPages);
            if (varCountPage != null && Integer.MIN_VALUE < varCountPage && varCountPage < Integer.MAX_VALUE) {
                return varCountPage;
            } else {
                throw new BookCountPageValidateException("Set book countPages is not valid.");
            }
        } catch (Exception e) {
            throw new BookCountPageValidateException("Set book countPages is not valid.");
        }
    }


    public static Double validateCostBook(String cost){
        try{
            Double varCost = Double.parseDouble(cost);
            if(Double.MIN_VALUE < varCost && varCost < Double.MAX_VALUE ) {
                return varCost;
            }else {
                throw new BookCostValidateException("Set book cost is not valid.");
            }
        } catch (Exception e) {
            throw new BookCostValidateException("Set book cost is not valid.");
        }
    }

}
