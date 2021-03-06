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

package org.semanticweb.owlapi.model;

import java.io.IOException;
import java.io.Serializable;

import org.semanticweb.owlapi.io.OWLOntologyDocumentTarget;


/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 02-Jan-2007<br><br>
 *
 * An ontology storer stores an ontology in a particular format at a location
 * specified by a particular URI.
 */
public interface OWLOntologyStorer extends Serializable {

    /**
     * Determines if this storer can store an ontology in the specified ontology format.
     * @param ontologyFormat The desired ontology format.
     * @return <code>true</code> if this storer can store an ontology in the desired
     * format.
     */
    boolean canStoreOntology(OWLOntologyFormat ontologyFormat);


    /** Stores an ontology to the specified ontology document IRI in the
     * specified format
     * 
     * @param manager
     *            The manager
     * @param ontology
     *            The ontology to be stored
     * @param documentIRI
     *            The ontology document IRI where the ontology will be saved to
     * @param ontologyFormat
     *            The format that the ontology should be stored in @throws
     *            OWLOntologyStorageException if there was a problem storing the
     *            ontology.
     * @throws IOException
     *             if there was an IOException when storing the ontology
     * @throws OWLOntologyStorageException
     *             if there was a problem storing the ontology
     * @deprecated use storeOntology(ontology, documentIRI, ontologyFormat) */
    @Deprecated
    void storeOntology(OWLOntologyManager manager, OWLOntology ontology, IRI documentIRI, OWLOntologyFormat ontologyFormat) throws OWLOntologyStorageException, IOException;

    /** Stores an ontology to the specified ontology document IRI in the
     * specified format
     * 
     * @param ontology
     *            The ontology to be stored
     * @param documentIRI
     *            The ontology document IRI where the ontology will be saved to
     * @param ontologyFormat
     *            The format that the ontology should be stored in @throws
     *            OWLOntologyStorageException if there was a problem storing the
     *            ontology.
     * @throws IOException
     *             if there was an IOException when storing the ontology
     * @throws OWLOntologyStorageException
     *             if there was a problem storing the ontology */
    void storeOntology(OWLOntology ontology, IRI documentIRI,
            OWLOntologyFormat ontologyFormat) throws OWLOntologyStorageException,
            IOException;


    /**
     * Stores an ontology to the specified target.  This method assumes the storer can write the
     * ontology to some stream.
     * @param manager The manager
     * @param ontology The ontology to be stored
     * @param target The target which describes the ontology document where the ontology should be stored
     * @param format The format in which to store the ontology
     * @throws OWLOntologyStorageException if there was a problem storing the ontology.
     * @throws IOException if there was an IOException when storing the ontology.
     */
    @Deprecated
    void storeOntology(OWLOntologyManager manager, OWLOntology ontology, OWLOntologyDocumentTarget target, OWLOntologyFormat format) throws OWLOntologyStorageException, IOException;

    /** Stores an ontology to the specified target. This method assumes the
     * storer can write the ontology to some stream.
     * 
     * @param ontology
     *            The ontology to be stored
     * @param target
     *            The target which describes the ontology document where the
     *            ontology should be stored
     * @param format
     *            The format in which to store the ontology
     * @throws OWLOntologyStorageException
     *             if there was a problem storing the ontology.
     * @throws IOException
     *             if there was an IOException when storing the ontology. */
    void storeOntology(OWLOntology ontology, OWLOntologyDocumentTarget target,
            OWLOntologyFormat format) throws OWLOntologyStorageException, IOException;
}
