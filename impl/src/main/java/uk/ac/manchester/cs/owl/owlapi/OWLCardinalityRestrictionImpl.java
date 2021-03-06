/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, The University of Manchester
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2011, University of Manchester
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.manchester.cs.owl.owlapi;

import org.semanticweb.owlapi.model.OWLCardinalityRestriction;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.OWLPropertyRange;


/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 26-Oct-2006<br><br>
 * @param <R> the range
 * @param <P> the property expression
 * @param <F> the value
 */
public abstract class OWLCardinalityRestrictionImpl<R extends OWLPropertyRange, P extends OWLPropertyExpression<R, P>, F extends OWLPropertyRange> extends OWLRestrictionImpl<R, P, F> implements OWLCardinalityRestriction<R, P, F> {


    private static final long serialVersionUID = 30402L;

    private final int cardinality;

    private final F filler;


    protected OWLCardinalityRestrictionImpl(P property, int cardinality, F filler) {
        super(property);
        this.cardinality = cardinality;
        this.filler = filler;
    }


    @Override
    public int getCardinality() {
        return cardinality;
    }


    @Override
    public F getFiller() {
        return filler;
    }


    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)) {
            if(!(obj instanceof OWLCardinalityRestriction)) {
                return false;
            }
            OWLCardinalityRestriction<R, P, F> other = (OWLCardinalityRestriction<R, P, F>) obj;
            return other.getCardinality() == cardinality &&
                    other.getFiller().equals(filler);
        }
        return false;
    }


    @SuppressWarnings("unchecked")
    @Override
    final protected int compareObjectOfSameType(OWLObject object) {
        OWLCardinalityRestriction<R, P, F> other = (OWLCardinalityRestriction<R, P, F>) object;
        int diff = getProperty().compareTo(other.getProperty());
        if (diff != 0) {
            return diff;
        }
        diff = getCardinality() - other.getCardinality();
        if (diff != 0) {
            return diff;
        }
        return getFiller().compareTo(other.getFiller());
    }
}
