/*
 * Copyright (c) 2017, University of California, Berkeley
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package edu.berkeley.cs.jqf.examples.jgrapht;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.pholser.junit.quickcheck.generator.GeneratorConfiguration;

/**
 * Configures a graph generator to generate graphs using a
 * GNM or GNP model.
 *
 * @author Rohan Padhye
 */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@GeneratorConfiguration
public @interface GraphModel {

    /**
     * The number of nodes to generate.
     *
     * Must be provided.
     */
    int nodes();


    /**
     * The number of edges to generate.
     *
     * If provided, a GNM model is used for generation,
     * and the <tt>p</tt> value is ignored.
     *
     * @return a value greater than or equal to zero.
     * @see <a href="https://en.wikipedia.org/wiki/Erdős–Rényi_model">
     *     GNM model</a>
     */
    int edges() default 0;

    /**
     * The probability of generating an edge
     * between a pair of nodes.
     *
     * This value is ignored if <tt>edges</tt> is provided.
     *
     * If this value is considered, a GNP model is used
     * for generation.
     *
     * @return a value between 0.0 and 1.0.
     * @see <a href="https://en.wikipedia.org/wiki/Erdős–Rényi_model">
     *     GNP model</a>
     */
    double p() default 1.0;

}
