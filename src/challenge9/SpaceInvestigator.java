package challenge9;

public class SpaceInvestigator {

    public static String spaceInvestigator(String text) {
        System.out.println("Original: \"" + text + "\"");
        System.out.println();

        text = removeLeadingTrailing(text);
        text = fixSpaceBeforePunctuation(text);
        text = fixDecimalPeriod(text);
        text = fixSpaceAfterPunctuation(text);
        text = removeDoubleSpaces(text);
        text = fixQuestionExclamationBeforeClosing(text);
        text = fixCommaBeforeClosingQuote(text);
        text = fixDashesHyphens(text);

        System.out.println();
        System.out.println("Fixed: \"" + text + "\"");
        return text;
    }

    // rule 1: no leading or trailing spaces
    private static String removeLeadingTrailing(String text) {
        String result = text.trim();
        if (!result.equals(text)) {
            System.out.println("Rule 1: removed leading/trailing spaces");
        }
        return result;
    }

    // rule 2: no space before punctuation marks
    private static String fixSpaceBeforePunctuation(String text) {
        String result = text.replaceAll(" ([.,!?;:])", "$1");
        if (!result.equals(text)) {
            System.out.println("Rule 2: removed space(s) before punctuation mark");
        }
        return result;
    }

    // rule 3: no space around decimal period between digits (e.g. 3 . 14 -> 3.14)
    private static String fixDecimalPeriod(String text) {
        String result = text.replaceAll("(\\d) \\.(\\d)", "$1.$2");
        result = result.replaceAll("(\\d)\\. (\\d)", "$1.$2");
        if (!result.equals(text)) {
            System.out.println("Rule 3: fixed space around decimal period");
        }
        return result;
    }

    // rule 4: space must come after a punctuation mark when followed by a letter
    private static String fixSpaceAfterPunctuation(String text) {
        String result = text.replaceAll("([.,;:!?])([a-zA-Z])", "$1 $2");
        if (!result.equals(text)) {
            System.out.println("Rule 4: added missing space after punctuation mark");
        }
        return result;
    }

    // rule 5: never two spaces in a row
    private static String removeDoubleSpaces(String text) {
        String result = text.replaceAll(" {2,}", " ");
        if (!result.equals(text)) {
            System.out.println("Rule 5: removed double (multiple) spaces");
        }
        return result;
    }

    // rule 6: no space between ! or ? and a closing bracket or quotation mark
    private static String fixQuestionExclamationBeforeClosing(String text) {
        String result = text.replaceAll("([!?]) ([)\\]\"'])", "$1$2");
        if (!result.equals(text)) {
            System.out.println("Rule 6: removed space between ! or ? and closing bracket/quote");
        }
        return result;
    }

    // rule 7: no space between a comma and a closing quotation mark
    private static String fixCommaBeforeClosingQuote(String text) {
        String result = text.replaceAll(", ([\"'])", ",$1");
        if (!result.equals(text)) {
            System.out.println("Rule 7: removed space between comma and closing quotation mark");
        }
        return result;
    }

    // rule 8: no spaces around a dash or hyphen between words or numerals
    private static String fixDashesHyphens(String text) {
        String result = text.replaceAll("(\\w) - (\\w)", "$1-$2");
        result = result.replaceAll("(\\w) -(\\w)", "$1-$2");
        result = result.replaceAll("(\\w)- (\\w)", "$1-$2");
        if (!result.equals(text)) {
            System.out.println("Rule 8: removed spaces around dash/hyphen between words");
        }
        return result;
    }

    public static void main(String[] args) {
        // string with all 8 types of spacing errors mixed in
        String text = "  Hello , world !  The price is 3 . 14 euros.She said (Really ! ) and went. " +
                "He replied \"Goodbye , \" and left. A well - known fact.  ";

        spaceInvestigator(text);
    }
}
