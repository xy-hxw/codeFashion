package common.fenci;

import java.util.Properties;

import edu.stanford.nlp.ie.crf.CRFClassifier;

public class CoreNLPSegment {
	private static CoreNLPSegment instance;
    private CRFClassifier classifier;

    private CoreNLPSegment(){
        Properties props = new Properties();
        props.setProperty("sighanCorporaDict", "data");
        props.setProperty("serDictionary", "data/dict-chris6.ser.gz");
        props.setProperty("inputEncoding", "UTF-8");
        props.setProperty("sighanPostProcessing", "true");
        classifier = new CRFClassifier(props);
        classifier.loadClassifierNoExceptions("data/ctb.gz", props);
        classifier.flags.setProperties(props);
    }

    public static CoreNLPSegment getInstance() {
        if (instance == null) {
            instance = new CoreNLPSegment();
        }

        return instance;
    }

    public String[] doSegment(String data) {
        return (String[]) classifier.segmentString(data).toArray();
    }

    public static void main(String[] args) {

        String sentence = "他和我在学校里常打桌球。";
        String ret[] = CoreNLPSegment.getInstance().doSegment(sentence);
        for (String str : ret) {
            System.out.println(str);
        }
    }
}
