package assertion;

import page.Page;

/**
 * Abstract assertions class
 * @param <T> Page or component class which assertions should be testing
 */
public abstract class Assertions<T extends Page> {

    protected T page;

    public void setPage(T page) {
        this.page = page;
    }
}
