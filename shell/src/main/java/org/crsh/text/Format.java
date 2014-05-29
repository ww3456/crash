/*
 * Copyright (C) 2012 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.crsh.text;

import java.io.IOException;

/** @author Julien Viet */
public enum Format {

  TEXT() {
    @Override
    public void write(CharSequence s, Appendable to) throws IOException {
      if (s.length() > 0) {
        to.append(s);
      }
    }
    @Override
    public void write(Style style, Appendable to) throws IOException {
    }
    @Override
    public void cls(Appendable to) throws IOException {
    }
  },

  ANSI() {
    @Override
    public void write(CharSequence s, Appendable to) throws IOException {
      if (s.length() > 0) {
        to.append(s);
      }
    }
    @Override
    public void write(Style style, Appendable to) throws IOException {
      style.writeAnsiTo(to);
    }
    @Override
    public void cls(Appendable to) throws IOException {
    }
  };

  public abstract void write(CharSequence s, Appendable to) throws IOException;

  public abstract void write(Style style, Appendable to) throws IOException;

  public abstract void cls(Appendable to) throws IOException;
}
