/*
 * Copyright (c) 2016, 2026, Guillermo Facundo Colunga and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 */
package com.guille.anotations;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.*;

/**
 * Signifies that a public API (public class, method or field) is subject to
 * incompatible changes, or even removal, in a future release. An API bearing
 * this annotation is exempt from any compatibility guarantees made by its
 * containing library. Note that the presence of this annotation implies nothing
 * about the quality or performance of the API in question, only the fact that
 * it is not "API-frozen." It is generally safe for applications to depend on
 * beta APIs, at the cost of some extra work during upgrades. However it is
 * generally inadvisable for libraries (which get included on users' CLASSPATHs,
 * outside the library developers' control) to do so.
 * 
 * @author Guillermo Facundo Colunga
 */
@Documented
@Retention(value = RetentionPolicy.CLASS)
@Target(value = { ANNOTATION_TYPE, CONSTRUCTOR, FIELD, METHOD, TYPE })
public @interface Beta {
}
