include gui-v2.inc

SRC_URI = " \
	https://github.com/nmbath/gui-v2/releases/download/v${PV}-web-page/venus-webassembly.zip;downloadfilename=venus-webassembly-${PV}-web-page.zip \
	file://calc-gui-v2-wasm-sha26.sh \
	file://localsettings \
"
SRC_URI[sha256sum] = "bae620c69b3a696e9e93b44caeead67f47280f22847c7e61d142d26221c0a5b9"
S = "${UNPACKDIR}/wasm"

inherit localsettings www

do_install() {
    make DESTDIR="${D}" PREFIX="${WWW_ROOT}/gui-v2" install
    install -d ${D}${bindir}
    install -m 755 ${UNPACKDIR}/calc-gui-v2-wasm-sha26.sh ${D}${bindir}
}

RDEPENDS:${PN} += "bash"
