/**
 * the interface HitNotifier, represent a hit notifier to objects.
 */
public interface HitNotifier {

    /**
     * add hl as a listener to hit events.
     * @param hl the listener we adding.
     */
    void addHitListener(HitListener hl);

    /**
     * remove hl as a listener to hit events.
     * @param hl the listener we removing.
     */
    void removeHitListener(HitListener hl);
}