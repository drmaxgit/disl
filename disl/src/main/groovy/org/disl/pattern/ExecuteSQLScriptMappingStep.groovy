/*
 * Copyright 2015 Karel H�bl <karel.huebl@gmail.com>.
 *
 * This file is part of disl.
 *
 * Disl is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Disl is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Disl.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.disl.pattern

import groovy.sql.Sql

import org.disl.meta.Context
import org.disl.meta.Mapping
import org.disl.meta.TableMapping;

abstract class ExecuteSQLScriptMappingStep<M extends Mapping> extends ExecuteSQLScriptStep {

	MappingPattern getPattern() {
		super.getPattern()
	}
	
	M getMapping() {
		getPattern().getMapping()
	}
	
	@Override
	public Sql getSql() {
		return Context.getSql(getMapping().getSchema());
	}

	public static ExecuteSQLScriptMappingStep create(String name,String code) {
		ExecuteSQLScriptMappingStep step=new ExecuteSQLScriptMappingStep() {
			String getCode() {
				code
			}
			
			Sql getSql() {
				Context.getSql(getPattern().getMapping().getSchema())
			}
		}
		step.name=name
		return step
	}



}