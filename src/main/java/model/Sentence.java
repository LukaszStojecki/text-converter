package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;


@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlSeeAlso(model.Text.class)
public class Sentence {

    private List<String> word;

}
