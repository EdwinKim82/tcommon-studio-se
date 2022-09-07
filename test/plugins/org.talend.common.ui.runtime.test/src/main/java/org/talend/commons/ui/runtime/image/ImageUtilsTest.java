// ============================================================================
//
// Copyright (C) 2006-2022 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.commons.ui.runtime.image;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.eclipse.jface.resource.ImageDescriptor;
import org.junit.Test;

public class ImageUtilsTest {
    
    @Test
    public void testCreateImageFromData() {
        byte[] data = new byte[] {12, 3, 5, 7, 23, 56};
        byte[] dup_data = new byte[data.length];
        System.arraycopy(data, 0, dup_data, 0, dup_data.length);
        
        ImageDescriptor createdImageFromData = ImageUtils.createImageFromData(data);
        assertSame(ImageUtils.createImageFromData(data), createdImageFromData);
        assertSame(ImageUtils.createImageFromData(dup_data), createdImageFromData);
    }
    
    @Test
    public void testDisposeImages() {
        byte[] data = new byte[] {12, 3, 5, 7, 23, 56};
        byte[] dup_data = new byte[data.length];
        System.arraycopy(data, 0, dup_data, 0, dup_data.length);
        
        ImageDescriptor createdImageFromData1 = ImageUtils.createImageFromData(data);
        ImageUtils.disposeImages(dup_data);
        ImageDescriptor createdImageFromData2 = ImageUtils.createImageFromData(data);
        assertNotSame(createdImageFromData1, createdImageFromData2);
    }
}
