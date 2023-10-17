package es.uah.lti.ltiformacion.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SisIdParser {
    public static final String CUSTOM_SIS_ID = "sis_id";

    private static final String TYPE_SIS_ID_BLUEPRINT_REGEX = "^([a-zA-Z])_([0-9]+)_([a-zA-Z\\.0-9]+)$";
    private static final String TYPE_SIS_ID_REGEX = "^([a-zA-Z])_([0-9]+)_([a-zA-Z\\.0-9]+)_([0-9]+)$";

    private static final int POSITION_SEMESTER_ON_SIS_ID_REGEX = 2;
    private static final int POSITION_SUBJECT_CODE_ON_SIS_ID_REGEX = 3;

    public static String getSubjectCode(String sisId) {
        return parseSisId(sisId, POSITION_SUBJECT_CODE_ON_SIS_ID_REGEX);
    }

    public static String getAcademicYear(String sisId) {
        return parseSisId(sisId, POSITION_SEMESTER_ON_SIS_ID_REGEX);
    }

    /**
     * Gets the Sis Id and parses it depending is a Section or Course
     *
     * @param sisId UOC's sisId
     * @param pos   Block position to get
     * @return String with the block
     */
    private static String parseSisId(String sisId, int pos) {
        String r = null;
        if (!StringUtils.isEmpty(sisId)) {
            Matcher matcher = getMatcher(sisId);
            if (matcher.find()) {
                r = matcher.group(pos);
            } else {
                matcher = getMatcherBluePrint(sisId);
                if (matcher.find()) {
                    r = matcher.group(pos);
                }
            }
        }
        return r;
    }

    private static Matcher getMatcher(String sis_id) {
        Pattern pattern = Pattern.compile(TYPE_SIS_ID_REGEX, Pattern.MULTILINE);

        return pattern.matcher(sis_id);
    }


    private static Matcher getMatcherBluePrint(String sis_id) {
        Pattern pattern = Pattern.compile(TYPE_SIS_ID_BLUEPRINT_REGEX, Pattern.MULTILINE);

        return pattern.matcher(sis_id);
    }

    public static boolean isBluePrint(String sis_id) {
        Pattern pattern = Pattern.compile(TYPE_SIS_ID_BLUEPRINT_REGEX, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(sis_id);

        return matcher.matches();
    }

    public static String getDomainCode(String sis_id) {
        String code = getSubjectCode(sis_id);
        String semester = getAcademicYear(sis_id);
        String domainCode = null;
        if (code != null && semester != null) {
            if (semester.length() > 3) {
                semester = semester.substring(semester.length() - 3);
            }
            domainCode = semester + "_" + code.replaceAll("\\.", "_");
        }
        return domainCode;
    }
}
