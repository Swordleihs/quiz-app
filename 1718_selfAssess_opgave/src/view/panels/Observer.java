package view.panels;

import domain.model.Category;
import domain.model.Question;

/**
 * author Ruben en vooral niet arne of arthur gotem
 */

public interface Observer {
    public void update(Category category, Question question);
}
