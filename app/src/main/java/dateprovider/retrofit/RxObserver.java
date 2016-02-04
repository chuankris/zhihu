package dateprovider.retrofit;

import rx.Observable;

/**
 * Created by qiuxuechuan on 2015/12/14.
 */
public class RxObserver extends Observable {
    /**
     * Creates an Observable with a Function to execute when it is subscribed to.
     * <p/>
     * <em>Note:</em> Use {@link #create(OnSubscribe)} to create an Observable, instead of this constructor,
     * unless you specifically have a need for inheritance.
     *
     * @param f {@link OnSubscribe} to be executed when  is called
     */
    protected RxObserver(OnSubscribe f) {
        super(f);
    }

}
