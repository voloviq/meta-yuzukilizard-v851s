FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
            file://so22t113-s.schema \
"

do_install:append() {
    install -Dm 0644 ${WORKDIR}/so22t113-s.schema ${D}${sysconfdir}/usbgx/so22t113-s.schema
}
