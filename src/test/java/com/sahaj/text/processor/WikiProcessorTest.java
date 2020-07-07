package com.sahaj.text.processor;

import com.sahaj.text.holder.AnswerHolder;
import com.sahaj.text.holder.InputHolder;
import com.sahaj.text.holder.QuestionHolder;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WikiProcessorTest {

    @Test
    public void process() {
        InputHolder inputHolder = new InputHolder();
        inputHolder.addInputText("Zebras are several species of African equids (horse family) united by their distinctive black and white stripes. Their stripes come in different patterns, unique to each individual. They are generally social animals that live in small harems to large herds. Unlike their closest relatives, horses and donkeys, zebras have never been truly domesticated. There are three species of zebras: the plains zebra, the Grévy's zebra and the mountain zebra. The plains zebra and the mountain zebra belong to the subgenus Hippotigris, but Grévy's zebra is the sole species of subgenus Dolichohippus. The latter resembles an ass, to which it is closely related, while the former two are more horse-like. All three belong to the genus Equus, along with other living equids. The unique stripes of zebras make them one of the animals most familiar to people. They occur in a variety of habitats, such as grasslands, savannas, woodlands, thorny scrublands, mountains, and coastal hills. However, various anthropogenic factors have had a severe impact on zebra populations, in particular hunting for skins and habitat destruction. Grévy's zebra and the mountain zebra are endangered. While plains zebras are much more plentiful, one subspecies, the quagga, became extinct in the late 19th century – though there is currently a plan, called the Quagga Project, that aims to breed zebras that are phenotypically similar to the quagga in a process called breeding back.");

        AnswerHolder.addAnswers("subgenus Hippotigris;the plains zebra, the Grévy's zebra and the mountain zebra;horses and donkeys;aims to breed zebras that are phenotypically similar to the quagga;Grévy's zebra and the mountain zebra");

        QuestionHolder.addQuestion("Which Zebras are endangered?");
        QuestionHolder.addQuestion("What is the aim of the Quagga Project?");
        QuestionHolder.addQuestion("Which animals are some of their closest relatives?");
        QuestionHolder.addQuestion("Which are the three species of zebras?");
        QuestionHolder.addQuestion("Which subgenus do the plains zebra and the mountain zebra belong to?");


        WikiProcessor wikiProcessor = new WikiProcessor();
        List<String> correctOut = wikiProcessor.process(inputHolder);

        correctOut.forEach(System.out::println);
    }
}