package nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PosTagRun {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(PosTagRun.class);

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        String txt = "Hello, My name is Gankhuu. I am twenty two years old. I was born in Mongolia.";
        CoreDocument doc = new CoreDocument(txt);
        stanfordCoreNLP.annotate(doc);
        List<CoreLabel> lblList = doc.tokens();
        for(CoreLabel lbl: lblList){
            String pos = lbl.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            System.out.println(lbl.originalText()+ " - " + pos);
        }
    }
}
