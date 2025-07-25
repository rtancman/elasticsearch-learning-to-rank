/*
 * Copyright [2016] Doug Turnbull
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.o19s.es.ltr.query;

import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.search.Scorer;

import java.io.IOException;

/**
 * Created by doug on 2/3/17.
 */
public class NoopScorer extends Scorer {
    private final DocIdSetIterator _noopIter;
    /**
     * Constructs a Scorer
     *
     * @param maxDocs maximum number of documents to score
     */
    public NoopScorer(int maxDocs) {
        _noopIter = DocIdSetIterator.all(maxDocs);

    }

    public NoopScorer(DocIdSetIterator iterator) {
        _noopIter = iterator;
    }

    @Override
    public int docID() {
        return _noopIter.docID();
    }

    @Override
    public float score() throws IOException {
        return 0;
    }

    @Override
    public DocIdSetIterator iterator() {
        return _noopIter;
    }

    /**
     * Return the maximum score that documents between the last {@code target}
     * that this iterator was {@link #advanceShallow(int) shallow-advanced} to
     * included and {@code upTo} included.
     */
    @Override
    public float getMaxScore(int upTo) throws IOException {
        return Float.POSITIVE_INFINITY;
    }
}
