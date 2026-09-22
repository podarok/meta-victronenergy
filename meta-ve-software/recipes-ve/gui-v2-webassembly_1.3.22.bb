include gui-v2.inc

SRC_URI = " \
	https://github.com/nmbath/gui-v2/releases/download/${PV}-containers/venus-webassembly.zip;downloadfilename=venus-webassembly-${PV}-containers.zip \
	file://calc-gui-v2-wasm-sha26.sh \
	file://localsettings \
"
SRC_URI[sha256sum] = "3d439c77b2811ab09edcca755486df5a759f966d5873236ec4b4f495e125a5cd"
S = "${UNPACKDIR}/wasm"

inherit localsettings www

do_install() {
    make DESTDIR="${D}" PREFIX="${WWW_ROOT}/gui-v2" install
    install -d ${D}${bindir}
    install -m 755 ${UNPACKDIR}/calc-gui-v2-wasm-sha26.sh ${D}${bindir}
}

RDEPENDS:${PN} += "bash"
