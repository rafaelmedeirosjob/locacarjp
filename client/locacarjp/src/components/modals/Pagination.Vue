<template>
    <div id="app">
        <vue-ads-pagination
            :total-items="totalItens"
            :max-visible-pages="5"
            :page="page"
            :loading="loading"
            @page-change="pageChange"
            @range-change="rangeChange"
        >
        <template slot-scope="props">
                <div class="vue-ads-pr-2 vue-ads-leading-loose">
                    {{ props.start }} à {{ props.end }} de {{ props.total }}
                </div>
            </template>
            <template
                slot="buttons"
                slot-scope="props"
            >
                <vue-ads-page-button
                    v-for="(button, key) in props.buttons"
                    :key="key"
                    v-bind="button"
                    @page-change="pageChange(button.page)"
                />
            </template>
        </vue-ads-pagination>
    </div>
</template>

<script>
import '../../../node_modules/@fortawesome/fontawesome-free/css/all.css';
import '../../../node_modules/vue-ads-pagination/dist/vue-ads-pagination.css';

import VueAdsPagination, { VueAdsPageButton } from 'vue-ads-pagination';

export default {
    name: 'Pagination',
    props: {
        totalItens: 0
    },
    components: {
        VueAdsPagination,
        VueAdsPageButton,
    },

    data () {
        return {
            loading: false,
            page: 0,
            start: 0,
            end: 0,
        };
    },

    methods: {
        pageChange (page) {
            this.page = page;
            this.$emit("getItens", page+1)
        },
        rangeChange (start, end) {
            this.start = start;
            this.end = end;
        },
    },
};
</script>