FILESEXTRAPATHS:prepend:poky := "${THISDIR}/files:"

# Example of recipe-core/psplash/psplash_git.bbappend
# (insert my-custom-psplash.png image in recipe-core/psplash/files folder)

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SPLASH_IMAGES = "file://psplash-logo.png;outsuffix=default"

SRC_URI += " \
    file://psplash-init \
    file://psplash-background-color-change.patch \
"