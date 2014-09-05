package spectrumChart;

import java.awt.Color;

public class scalaCromaticaKelvin extends scalaCromatica {
	int[] raw = { 0xffcc0000, 0xffcc0000, 0xffcc0000, 0xffcc0000, 0xffff2b00,
			0xffcc0000, 0xffff2b00, 0xffcc2b00, 0xffcc0000, 0xffcc2b00,
			0xffcc2b00, 0xffcc2b00, 0xffcc2b00, 0xffff2b00, 0xffcc5500,
			0xffcc2b00, 0xffff2b00, 0xffcc5500, 0xffff2b00, 0xffcc5500,
			0xffcc2b00, 0xffff5500, 0xffcc5500, 0xffff5500, 0xffcc5500,
			0xffcc5500, 0xffff5500, 0xffcc5500, 0xffff8000, 0xffcc5500,
			0xffff8000, 0xffcc8000, 0xffff5500, 0xffcc8000, 0xffff5500,
			0xffcc8000, 0xffff8000, 0xffcc8000, 0xffff8000, 0xffccaa00,
			0xffff8000, 0xffffaa00, 0xffcc8000, 0xffffaa00, 0xffffaa00,
			0xffff8000, 0xffffaa00, 0xffccaa00, 0xffffaa00, 0xffffaa00,
			0xffffaa00, 0xffffaa00, 0xffffaa00, 0xffffd500, 0xffffaa00,
			0xffffd500, 0xffffd500, 0xffffaa00, 0xffccd500, 0xffffd500,
			0xffffd500, 0xffccd500, 0xffffd500, 0xffffff00, 0xffffd500,
			0xffffd500, 0xffffff00, 0xffffd500, 0xffffff00, 0xffffff00,
			0xffffff00, 0xffffff00, 0xffffff00, 0xffffff00, 0xffffff00,
			0xffffff00, 0xffffff33, 0xffffff00, 0xffffff00, 0xffffff00,
			0xffffff00, 0xffffff33, 0xffffff00, 0xffffff33, 0xffffff00,
			0xffffff33, 0xffffff00, 0xffffff33, 0xffffff00, 0xffffff33,
			0xffffff00, 0xffffff33, 0xffffff33, 0xffffff33, 0xffffff00,
			0xffffff33, 0xffffff33, 0xffffff33, 0xffffff33, 0xffffff33,
			0xffffff33, 0xffffff33, 0xffffff33, 0xffffff33, 0xffffff66,
			0xffffff33, 0xffffff33, 0xffffff66, 0xffffff33, 0xffffff66,
			0xffffff33, 0xffffff66, 0xffffff33, 0xffffff66, 0xffffff66,
			0xffffff33, 0xffffff66, 0xffffff66, 0xffffff66, 0xffffff66,
			0xffffff66, 0xffffff66, 0xffffff66, 0xffffff66, 0xffffff66,
			0xffffff66, 0xffffff66, 0xffffff66, 0xffffff99, 0xffffff66,
			0xffffff99, 0xffffff66, 0xffffff99, 0xffffff66, 0xffffff99,
			0xffffff66, 0xffffff99, 0xffffff66, 0xffffff99, 0xffffff66,
			0xffffff99, 0xffffff99, 0xffffff99, 0xffffff66, 0xffffff99,
			0xffffff99, 0xffffff99, 0xffffff99, 0xffffff99, 0xffffff99,
			0xffffff99, 0xffffff99, 0xffffff99, 0xffffff99, 0xffffffcc,
			0xffffff99, 0xffffffcc, 0xffffff99, 0xffffff99, 0xffffffcc,
			0xffffff99, 0xffffffcc, 0xffffff99, 0xffffffcc, 0xffffff99,
			0xffffffcc, 0xffffffcc, 0xffffffcc, 0xffffffcc, 0xffffffcc,
			0xffffffcc, 0xffffffcc, 0xffffffcc, 0xffffffcc, 0xffffffcc,
			0xffffffcc, 0xffffffcc, 0xffffffff, 0xffffffcc, 0xffffffcc,
			0xffffffcc, 0xffffffff, 0xffffffcc, 0xffffffcc, 0xffffffcc,
			0xffffffff, 0xffffffcc, 0xffffffff, 0xffffffcc, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffcc, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffccffff, 0xffffffff, 0xffffffff, 0xffccffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffccffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff, 0xffccffff,
			0xffffffff, 0xffffffff, 0xffffffff, 0xffccffff, 0xffffffff,
			0xffffffff, 0xffccffff, 0xffffffff, 0xffffffff, 0xffccffff,
			0xffffffff, 0xffccffff, 0xffffffff, 0xffffffff, 0xffccffff,
			0xffffffff, 0xffccffff, 0xffffffff, 0xffccffff, 0xffffffff,
			0xffccffff, 0xffffffff, 0xffccffff, 0xffffffff, 0xffccffff,
			0xffffffff, 0xffccffff, 0xffffffff, 0xffccd5ff, 0xffffffff,
			0xffccffff, 0xffffffff, 0xffccd5ff, 0xffffffff, 0xffccffff,
			0xffccffff, 0xffffd5ff, 0xffccffff, 0xffffffff, 0xffccd5ff,
			0xffffffff, 0xffccffff, 0xffffd5ff, 0xffccffff, 0xffffffff,
			0xffccd5ff, 0xffccffff, 0xffffffff, 0xffccd5ff, 0xffccffff,
			0xffccd5ff, 0xffffffff, 0xffccd5ff, 0xffccffff, 0xffccd5ff,
			0xffccffff, 0xffccd5ff, 0xffccffff, 0xffffd5ff, 0xffccffff,
			0xffccd5ff, 0xffccffff, 0xffccffff, 0xffccffff, 0xffccd5ff,
			0xffccffff, 0xffccffff, 0xffccffff, 0xffccd5ff, 0xffccffff,
			0xffccffff, 0xffccffff, 0xffffd5ff, 0xffccffff, 0xffccffff,
			0xffccd5ff, 0xffffffff, 0xffccffff, 0xffccffff, 0xffccffff,
			0xffccffff, 0xffccd5ff, 0xffccffff, 0xffccffff, 0xffccffff,
			0xffccd5ff, 0xffccffff, 0xffccffff, 0xffccffff, 0xffccffff,
			0xffccffff, 0xffccffff, 0xffccffff, 0xffccffff, 0xffccffff,
			0xffccffff, 0xffccffff, 0xffccffff, 0xffccffff, 0xffccffff,
			0xffccffff, 0xff99ffff, 0xffccffff, 0xffccffff, 0xff99ffff,
			0xffccffff, 0xffccffff, 0xffccd5ff, 0xffccffff, 0xffccffff,
			0xffccffff, 0xffccd5ff, 0xffccffff, 0xffccffff, 0xffccffff,
			0xffccd5ff, 0xffccffff, 0xffccffff, 0xffccd5ff, 0xffccffff,
			0xffccffff, 0xffccd5ff, 0xff99ffff, 0xffccffff, 0xffccd5ff,
			0xff99ffff, 0xffccffff, 0xffccd5ff, 0xffccffff, 0xff99d5ff,
			0xffccffff, 0xff99d5ff, 0xffccffff, 0xffccffff, 0xff99d5ff,
			0xffccffff, 0xff99ffff, 0xffccd5ff, 0xffccffff, 0xff99ffff,
			0xffccd5ff, 0xff99ffff, 0xffccffff, 0xff99d5ff, 0xffccffff,
			0xff99ffff, 0xffccd5ff, 0xff99ffff, 0xffccffff, 0xff99d5ff,
			0xffccffff, 0xff99ffff, 0xffccffff, 0xff99d5ff, 0xffccffff,
			0xff99ffff, 0xffccffff, 0xff99d5ff, 0xffccffff, 0xff99ffff,
			0xffccffff, 0xff99d5ff, 0xffccffff, 0xff99d5ff, 0xff99ffff,
			0xff99d5ff, 0xffccffff, 0xff99d5ff, 0xff99ffff, 0xffccd5ff,
			0xff99ffff, 0xff99d5ff, 0xffccffff, 0xff99d5ff, 0xff99ffff,
			0xff99d5ff, 0xff99ffff, 0xffccffff, 0xff99d5ff, 0xff99ffff,
			0xff99d5ff, 0xffccffff, 0xff99d5ff, 0xff99ffff, 0xff99d5ff,
			0xff99d5ff, 0xff99d5ff, 0xff99ffff, 0xff99d5ff, 0xff99ffcc,
			0xff99d5ff, 0xff99d5ff, 0xff99ffff, 0xff99d5ff, 0xff99d5ff,
			0xff99d5ff, 0xff99d5ff, 0xff99d5ff, 0xff99d5ff, 0xff99d5cc,
			0xff99d5ff, 0xff99d5ff, 0xff66d5ff, 0xff99d5ff, 0xff66d5cc,
			0xff99d5ff, 0xff99aaff, 0xff66d5cc, 0xff99aaff, 0xff66d5cc,
			0xff99aaff, 0xff66d5cc, 0xff99aaff, 0xff66aacc, 0xff99d5cc,
			0xff66aaff, 0xff66aacc, 0xff99aacc, 0xff66aaff, 0xff66d5cc,
			0xff66aacc, 0xff66aaff, 0xff66aacc, 0xff99aacc, 0xff66aacc,
			0xff66aacc, 0xff66aaff, 0xff66aacc, 0xff66aacc, 0xff66aacc,
			0xff66aacc, 0xff66aacc, 0xff66aacc, 0xff66aacc };

	Color[] colori;

	public scalaCromaticaKelvin() {
		colori = new Color[raw.length];

		int i;
		for (i = 0; i < raw.length; i++)
			colori[i] = new Color(raw[i]);

		super.raw = raw;
		super.colori = colori;
	}

}