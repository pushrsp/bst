package me.project;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BSTTest {
    static final int[] arr = {8, 3, 10, 1, 6, 14, 4, 7, 13};

    @Test
    public void can_get_proper_max() throws Exception {
        //given
        BST<Integer> bst = getBst();

        //when
        Integer max = bst.max();

        //then
        assertThat(max).isEqualTo(14);
    }

    @Test
    public void can_get_proper_max_with_recursive() throws Exception {
        //given
        BST<Integer> bst = getBst();

        //when
        Integer max = bst.maxRec();

        //then
        assertThat(max).isEqualTo(14);
    }

    @Test
    public void can_get_proper_min() throws Exception {
        //given
        BST<Integer> bst = getBst();

        //when
        Integer min = bst.min();

        //then
        assertThat(min).isEqualTo(1);
    }

    @Test
    public void can_get_proper_min_with_recursive() throws Exception {
        //given
        BST<Integer> bst = getBst();

        //when
        Integer min = bst.minRec();

        //then
        assertThat(min).isEqualTo(1);
    }

    @Test
    public void preOrder() throws Exception {
        //given
        BST<Integer> bst = getBst();
        bst.preOrder();

        //when

        //then
    }

    @Test
    public void inOrder() throws Exception {
        //given
        BST<Integer> bst = getBst();
        bst.inOrder();

        //when

        //then
    }

    @Test
    public void postOrder() throws Exception {
        //given
        BST<Integer> bst = getBst();
        bst.postOrder();
        //when

        //then
    }

    @Test
    public void can_delete_value() throws Exception {
        //given
        BST<Integer> bst = getBst();
        bst.delete(14);

        //when
        Integer max = bst.max();

        //then
        assertThat(max).isEqualTo(13);
    }

    private BST<Integer> getBst() {
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }

        return bst;
    }
}
